package com.jzheadley.augmentedshopper.Adapter;

import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jzheadley.augmentedshopper.R;
import com.jzheadley.augmentedshopper.services.api.Review;

import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder> {

    private List<Review> reviews;

    public ReviewsAdapter(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.reviews_card, viewGroup, false);
        return new ReviewsAdapter.ReviewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder reviewViewHolder, int i) {
        reviewViewHolder.rating.setRating(reviews.get(i).getRating());
        reviewViewHolder.content.setText(reviews.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }
//    @Override
//    public void onAttachedToRecylcerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//    }

    public static class ReviewViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        AppCompatRatingBar rating;
        TextView content;

        ReviewViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.reviews_card);
            rating = itemView.findViewById(R.id.review_rating);
            content = itemView.findViewById(R.id.review_content);
        }

    }

}
