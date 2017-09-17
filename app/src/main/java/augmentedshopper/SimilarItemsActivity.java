package augmentedshopper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import augmentedshopper.Adapter.SimilarItemsAdapter;
import augmentedshopper.services.GoogleSearchService;
import augmentedshopper.services.api.GoogleSearchApi;
import augmentedshopper.services.api.Item;
import augmentedshopper.services.api.ResultsList;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SimilarItemsActivity extends AppCompatActivity {

    private static final String TAG = "SimilarItemsActivity";
    private List<Item> items = new ArrayList<>();
    private SimilarItemsAdapter adapter;
    private RecyclerView recyclerView;
    private GoogleSearchApi googleSearchApi;
    public final String cx = "009610786516065341765:eeyebvizksq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similar_items);

        recyclerView = (RecyclerView) findViewById(R.id.similarItem_recyclerview);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);
        googleSearchApi = new GoogleSearchService().getGoogleSearchApi();
        googleSearchApi.searchGoogle("AIzaSyDwSYJNpsaPKOhlATRt_2jEAhwufGEBVW4", cx, "monster energy 16oz")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultsList>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.d(TAG, "onSubscribe: Subscribed");
                    }

                    @Override
                    public void onNext(@NonNull ResultsList resultsList) {
                        Log.d(TAG, "onNext: " + resultsList);
                        setItems(resultsList.getItems());
                        Log.d(TAG, "onNext: " + resultsList.getItems());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: finished");

                    }
                });



    }

    public void setItems(List<Item> items) {
        Log.d(TAG, "setItems: Items Are" + items);
        this.items = items;
        adapter = new SimilarItemsAdapter(items);
        recyclerView.setAdapter(adapter);

    }

    public List<Item> getTopRecipes(int count) {
        List<Item> topResults = null;
        for (int i = 0; i < count; i++) {
            topResults.add(items.get(i));
        }
        return topResults;
    }
}
