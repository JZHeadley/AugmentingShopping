package augmentedshopper.services.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodToForkApi {

    @GET("search")
    Observable<RecipeList> searchRecipes(@Query("key") String apiKey, @Query("q") String searchString);

}
