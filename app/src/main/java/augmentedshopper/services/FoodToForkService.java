package augmentedshopper.services;

import augmentedshopper.services.api.FoodToForkApi;

public class FoodToForkService {
    private FoodToForkApi foodToForkApi;

    public FoodToForkService() {
        foodToForkApi = ServiceFactory.createRetrofitDebugService(FoodToForkApi.class, "http://food2fork.com/api/");
    }

    public FoodToForkApi getFoodToForkApi() {
        return foodToForkApi;
    }
}
