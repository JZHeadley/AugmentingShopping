package com.jzheadley.augmentedshopper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jzheadley.augmentedshopper.Adapter.ReviewsAdapter;
import com.jzheadley.augmentedshopper.services.api.Review;

import java.util.ArrayList;
import java.util.Collections;
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
        reviews.add(new Review(5, "This product is amazing! Definitely would buy again"));
        reviews.add(new Review(4, "Just okay, not my favorite, but I paid for it so I might as well keep it."));
        reviews.add(new Review(5, "OUTSTANDING!!! People said orange was the new black, but THIS is the new black. I wish I had more all the time, need a weekly delivery service of it."));
        reviews.add(new Review(1, "Terrible. Just awful. Wouldn't recommend it to my worst enemy."));
        reviews.add(new Review(3, "I mean....it's alright, don't really see what the hype is about."));
        reviews.add(new Review(5, "Can I get a heck yes??!!! Finally something I love."));
        Collections.shuffle(reviews);
    }
}
