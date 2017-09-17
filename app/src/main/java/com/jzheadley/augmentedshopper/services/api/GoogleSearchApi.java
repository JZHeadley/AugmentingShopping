package com.jzheadley.augmentedshopper.services.api;

/**
 * Created by sean on 9/17/17.
 */

import retrofit2.http.GET;
import retrofit2.http.Query;

import io.reactivex.Observable;

public interface GoogleSearchApi {

    @GET("v1")
    Observable<ResultsList> searchGoogle(@Query("key") String apiKey, @Query("cx") String cx, @Query("q") String searchString);
//cx 009610786516065341765:eeyebvizksq
    //apiKey
}
