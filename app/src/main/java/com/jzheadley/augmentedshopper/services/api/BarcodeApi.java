package com.jzheadley.augmentedshopper.services.api;

import retrofit2.http.GET;
import retrofit2.http.Query;

import io.reactivex.Observable;

public interface BarcodeApi {

    @GET("lookup")
    Observable<UPCResponse> findItemInformation(@Query("upc") String barcode/*, @Query("key") String apiKey*/);
}
