package com.google.android.gms.samples.vision.face.multitracker;

import com.google.ar.core.Frame;
import com.google.ar.core.Session;
import com.google.ar.core.exceptions.CameraException;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class SurfaceViewRenderer implements GLSurfaceView.Renderer {
    private static final String TAG = "SurfaceViewRenderer";
    private Context context;
    private Session session;
    private BackgroundRenderer mBackgroundRenderer;

    public SurfaceViewRenderer(MultiTrackerActivity multiTrackerActivity, Session session) {
        this.context = multiTrackerActivity;
        this.session = session;
        mBackgroundRenderer = new BackgroundRenderer();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Log.d(TAG, "onSurfaceCreated: ");
        GLES20.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);

        mBackgroundRenderer.createOnGlThread(/*context=*/context);
        session.setCameraTextureName(mBackgroundRenderer.getTextureId());
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        session.setDisplayGeometry(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        try {
            Frame frame = session.update();

            // Draw background.
            // mBackgroundRenderer.draw(frame);

            // Get projection matrix.
            // float[] projmtx = new float[16];
            // session.getProjectionMatrix(projmtx, 0, 0.1f, 100.0f);
            // Get camera matrix and draw.
            // float[] viewmtx = new float[16];
            // frame.getViewMatrix(viewmtx, 0);
        } catch (CameraException e) {
            e.printStackTrace();
        }
    }
}
