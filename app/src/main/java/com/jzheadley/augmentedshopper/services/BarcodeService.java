package com.jzheadley.augmentedshopper.services;

import com.jzheadley.augmentedshopper.services.api.BarcodeApi;

public class BarcodeService {
    private BarcodeApi barcodeapi;

    public BarcodeService() {
        barcodeapi = ServiceFactory.createRetrofitDebugService(BarcodeApi.class, "https://api.upcitemdb.com/prod/trial/");
    }

    public BarcodeApi getBarcodeapi() {
        return barcodeapi;
    }
}
