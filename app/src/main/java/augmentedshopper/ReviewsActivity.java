package augmentedshopper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import augmentedshopper.Adapter.ReviewsAdapter;
import augmentedshopper.services.api.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewsActivity extends AppCompatActivity {
    private List<Review> reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        RecyclerView review_card_rv = (RecyclerView) findViewById(R.id.review_card_rv);
        review_card_rv.setLayoutManager(new LinearLayoutManager(this));

        initializeReviews();
        ReviewsAdapter adapter = new ReviewsAdapter(reviews);
        review_card_rv.setAdapter(adapter);
    }

    private void initializeReviews() {
        reviews = new ArrayList<>();
        reviews.add(new Review(5, "This is a review"));
        reviews.add(new Review(4, "This is a review"));
        reviews.add(new Review(3, "This is a review"));
        reviews.add(new Review(2, "This is a review"));
    }
}
