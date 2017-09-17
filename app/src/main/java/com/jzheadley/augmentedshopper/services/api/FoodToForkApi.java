package com.jzheadley.augmentedshopper.services.api;

import retrofit2.http.GET;
import retrofit2.http.Query;

import io.reactivex.Observable;

public interface FoodToForkApi {

    @GET("search")
    Observable<RecipeList> searchRecipes(@Query("key") String apiKey, @Query("q") String searchString);

}
