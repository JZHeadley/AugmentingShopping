package augmentedshopper.services;

import augmentedshopper.services.api.GoogleSearchApi;

public class GoogleSearchService {
    private GoogleSearchApi googleSearchApi;

    public GoogleSearchService() {
        googleSearchApi = ServiceFactory.createRetrofitDebugService(GoogleSearchApi.class, "https://www.googleapis.com/customsearch/");
    }

    public GoogleSearchApi getGoogleSearchApi() {
        return googleSearchApi;
    }
}
