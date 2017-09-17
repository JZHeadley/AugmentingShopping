package com.jzheadley.augmentedshopper.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jzheadley.augmentedshopper.R;
import com.jzheadley.augmentedshopper.services.api.Item;

import java.util.List;

public class SimilarItemsAdapter extends RecyclerView.Adapter<SimilarItemsAdapter.ItemViewHolder> {

    private List<Item> results;

    public SimilarItemsAdapter(List<Item> results) {
        this.results = results;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.similar_items_card, parent, false);
        return new SimilarItemsAdapter.ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final Item item = results.get(position);
        holder.itemName.setText(item.getTitle());
//        holder.ratingBar.setRating(Float.parseFloat(recipe.getSocialRank() + ""));
//        Glide.with(holder.cardView.getContext())
//                .load(item.getUrl())
//                .centerCrop()
//                .fitCenter()
//                .into(holder.imageView);

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.getF2fUrl()));
//                view.getContext().startActivity(browserIntent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        RatingBar ratingBar;
        ImageView imageView;
        TextView itemName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.similar_item_card);
            ratingBar = (RatingBar) itemView.findViewById(R.id.similar_item_ratingBar);
            imageView = (ImageView) itemView.findViewById(R.id.similar_item_image);
            itemName = (TextView) itemView.findViewById(R.id.similar_item_name);
        }
    }

}