/*
 * Copyright (C) The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jzheadley.augmentedshopper.googlevision;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.MultiDetector;
import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.jzheadley.augmentedshopper.PriceComparisonActivity;
import com.jzheadley.augmentedshopper.R;
import com.jzheadley.augmentedshopper.RecipesActivity;
import com.jzheadley.augmentedshopper.SimilarItemsActivity;
import com.jzheadley.augmentedshopper.googlevision.camera.CameraSourcePreview;
import com.jzheadley.augmentedshopper.services.BarcodeService;
import com.jzheadley.augmentedshopper.services.api.UPCResponse;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Activity for the multi-tracker app.  This app detects faces and barcodes with the rear facing
 * camera, and draws overlay graphics to indicate the position, size, and ID of each face and
 * barcode.
 */
public final class MultiTrackerActivity extends AppCompatActivity implements BarcodeTracker.BarcodeGraphicTrackerCallback {
    private static final String TAG = "MultiTracker";
    private static final int RC_HANDLE_GMS = 9001;
    // permission request codes need to be < 256
    private static final int RC_HANDLE_CAMERA_PERM = 2;
    private CameraSource mCameraSource = null;
    private CameraSourcePreview mPreview;

    /**
     * Initializes the UI and creates the detector pipeline.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        mPreview = (CameraSourcePreview) findViewById(R.id.preview);

        // Check for the camera permission before accessing the camera.  If the
        // permission is not granted yet, request permission.
        int rc = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (rc == PackageManager.PERMISSION_GRANTED) {
            createCameraSource();
        } else {
            requestCameraPermission();
        }
    }

    /**
     * Handles the requesting of the camera permission.  This includes
     * showing a "Snackbar" message of why the permission is needed then
     * sending the request.
     */
    private void requestCameraPermission() {
        Log.w(TAG, "Camera permission is not granted. Requesting permission");

        final String[] permissions = new String[]{Manifest.permission.CAMERA};

        if (!ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);
            return;
        }

        final Activity thisActivity = this;

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(thisActivity, permissions,
                        RC_HANDLE_CAMERA_PERM);
            }
        };

    }


    /**
     * Creates and starts the camera.  Note that this uses a higher resolution in comparison
     * to other detection examples to enable the barcode detector to detect small barcodes
     * at long distances.
     */
    private void createCameraSource() {


        Context context = getApplicationContext();

        // A barcode detector is created to track barcodes.  An associated multi-processor instance
        // is set to receive the barcode detection results, track the barcodes, and maintain
        // graphics for each barcode on screen.  The factory is used by the multi-processor to
        // create a separate tracker instance for each barcode.
        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(context)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();
        BarcodeTrackerFactory barcodeFactory = new BarcodeTrackerFactory(this);
        barcodeDetector.setProcessor(new MultiProcessor.Builder<>(barcodeFactory).build());

        // A multi-detector groups the two detectors together as one detector.  All images received
        // by this detector from the camera will be sent to each of the underlying detectors, which
        // will each do face and barcode detection, respectively.  The detection results from each
        // are then sent to associated tracker instances which maintain per-item graphics on the
        // screen.
        MultiDetector multiDetector = new MultiDetector.Builder()
                .add(barcodeDetector)
                .build();

        if (!multiDetector.isOperational()) {
            // Note: The first time that an app using the barcode or face API is installed on a
            // device, GMS will download a native libraries to the device in order to do detection.
            // Usually this completes before the app is run for the first time.  But if that
            // download has not yet completed, then the above call will not detect any barcodes
            // and/or faces.
            //
            // isOperational() can be used to check if the required native libraries are currently
            // available.  The detectors will automatically become operational once the library
            // downloads complete on device.
            Log.w(TAG, "Detector dependencies are not yet available.");

            // Check for low storage.  If there is low storage, the native library will not be
            // downloaded, so detection will not become operational.
            IntentFilter lowstorageFilter = new IntentFilter(Intent.ACTION_DEVICE_STORAGE_LOW);
            boolean hasLowStorage = registerReceiver(null, lowstorageFilter) != null;

            if (hasLowStorage) {
                Toast.makeText(this, R.string.low_storage_error, Toast.LENGTH_LONG).show();
                Log.w(TAG, getString(R.string.low_storage_error));
            }
        }

        // Creates and starts the camera.  Note that this uses a higher resolution in comparison
        // to other detection examples to enable the barcode detector to detect small barcodes
        // at long distances.
        mCameraSource = new CameraSource.Builder(getApplicationContext(), multiDetector)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setAutoFocusEnabled(true)
                .setRequestedPreviewSize(1600, 1024)
                .setRequestedFps(60.0f)
                .build();
    }

    /**
     * Restarts the camera.
     */
    @Override
    protected void onResume() {
        super.onResume();

        startCameraSource();
    }

    /**
     * Stops the camera.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mPreview.stop();
    }

    /**
     * Releases the resources associated with the camera source, the associated detectors, and the
     * rest of the processing pipeline.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCameraSource != null) {
            mCameraSource.release();
        }
    }


    /**
     * Starts or restarts the camera source, if it exists.  If the camera source doesn't exist yet
     * (e.g., because onResume was called before the camera source was created), this will be called
     * again when the camera source is created.
     */
    private void startCameraSource() {

        // check that the device has play services available.
        int code = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(
                getApplicationContext());
        if (code != ConnectionResult.SUCCESS) {
            Dialog dlg = GoogleApiAvailability.getInstance().getErrorDialog(this, code, RC_HANDLE_GMS);
            dlg.show();
        }

        if (mCameraSource != null) {
            try {
                mPreview.start(mCameraSource);
            } catch (IOException e) {
                Log.e(TAG, "Unable to start camera source.", e);
                mCameraSource.release();
                mCameraSource = null;
            }
        }
    }

    public void storeSwitcher(final Context view, UPCResponse upcResponse) {
        Intent intent = new Intent(this, PriceComparisonActivity.class);
        String searchTerm = upcResponse.getItems().get(0).getTitle();
        searchTerm = searchTerm.replaceAll(" ", "+");
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.aisle411.com/shops/results.php?searchTerm=" + searchTerm + "&addressNear=Richmond%2C+VA%2C+USA&mapLocateLat=37.5407246&mapLocateLon=-77.4360481#"));
        view.startActivity(browserIntent);


    }

    public void recipeSwitcher(View view, UPCResponse upcResponse) {
        Intent intent = new Intent(this, RecipesActivity.class);
        intent.putExtra("foodItem", upcResponse.getItems().get(0).getTitle());
        startActivity(intent);
    }

    public void similarSwitcher(View view, UPCResponse upcResponse) {
        Intent intent = new Intent(this, SimilarItemsActivity.class);
        intent.putExtra("similarItem", upcResponse.getItems().get(0).getTitle());
        startActivity(intent);
    }

    @Override
    public void onDetectedQrCode(final Barcode barcode) {
        Log.d(TAG, "onDetectedQrCode: " + barcode.displayValue);
        BarcodeService barcodeService = new BarcodeService();
        barcodeService.getBarcodeapi().findItemInformation(barcode.displayValue)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UPCResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull final UPCResponse upcResponse) {
                        (findViewById(R.id.rating)).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                storeSwitcher(view.getContext(), upcResponse);
                            }
                        });
                        (findViewById(R.id.recipe)).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                recipeSwitcher(view, upcResponse);
                            }
                        });
                        (findViewById(R.id.shoppping)).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                similarSwitcher(view, upcResponse);
                            }
                        });
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        runOnUiThread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void run() {
                final LinearLayout layout = (LinearLayout) findViewById(R.id.btn_group);
                layout.setVisibility(View.VISIBLE);
                layout.setX(Math.max(Math.min(barcode.getBoundingBox().right - 500, 700), 0));
                layout.setY(Math.max(Math.min(barcode.getBoundingBox().top + 100, 1000), 20));
                layout.setScaleX(Math.max(Math.min((barcode.getBoundingBox().width() / 100.0f), 1.2f), 0.2f));
                layout.setScaleY(Math.max(Math.min((barcode.getBoundingBox().width() / 100.0f), 1.2f), 0.2f));
                Log.d(TAG, "run: " + layout.getX() + "\t" + layout.getY());

                layout.bringToFront();
                // Toast.makeText(getApplicationContext(), "Detected a code with text:\t" + barcode.displayValue, Toast.LENGTH_SHORT).show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        layout.setVisibility(View.INVISIBLE);
                    }
                }, 7500);
            }
        });

    }

//    public void onClick(View view) {
//        Intent intent;
//        switch (view.getId()) {
//            case R.id.rating1:
//                intent = new Intent(view.getContext(), ReviewsActivity.class);
//                view.getContext().startActivity(intent);
//                break;
//            case R.id.rating2:
//                intent = new Intent(view.getContext(), ReviewsActivity.class);
//                view.getContext().startActivity(intent);
//                break;
//            case R.id.rating3:
//                intent = new Intent(view.getContext(), ReviewsActivity.class);
//                view.getContext().startActivity(intent);
//                break;
//        }
//    }
}
