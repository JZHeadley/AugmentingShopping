package augmentedshopper.Adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import augmentedshopper.R;
import augmentedshopper.services.api.Recipe;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {

    private List<Recipe> recipes;

    public RecipesAdapter(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recipes_card, parent, false);
        return new RecipesAdapter.RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        final Recipe recipe = recipes.get(position);
        holder.recipeTitle.setText(recipe.getTitle());
        holder.ratingBar.setRating(Float.parseFloat(recipe.getSocialRank() + ""));
        Glide.with(holder.cardView.getContext())
                .load(recipe.getImageUrl())
                .centerCrop()
                .fitCenter()
                .into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.getF2fUrl()));
                view.getContext().startActivity(browserIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }


    static class RecipeViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        RatingBar ratingBar;
        ImageView imageView;
        TextView recipeTitle;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.recipe_card);
            ratingBar = (RatingBar) itemView.findViewById(R.id.recipe_ratingBar);
            imageView = (ImageView) itemView.findViewById(R.id.recipe_image);
            recipeTitle = (TextView) itemView.findViewById(R.id.recipe_title);
        }
    }

}
