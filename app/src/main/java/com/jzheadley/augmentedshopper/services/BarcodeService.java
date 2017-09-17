package com.jzheadley.augmentedshopper.services;

import com.jzheadley.augmentedshopper.services.api.FoodToForkApi;

public class BarcodeService {
    private FoodToForkApi barcodeapi;

    public BarcodeService() {
        barcodeapi = ServiceFactory.createRetrofitDebugService(FoodToForkApi.class, "https://api.upcitemdb.com/prod/trial/");
    }

    public FoodToForkApi getBarcodeapi() {
        return barcodeapi;
    }
}
