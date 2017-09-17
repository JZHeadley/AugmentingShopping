package com.jzheadley.augmentedshopper.services.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sean on 9/16/17.
 */

public class RecipeList {
    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("recipes")
    @Expose
    public List<Recipe> recipes = null;

    public RecipeList() {
    }

    public RecipeList(Integer count, List<Recipe> recipes) {
        this.count = count;
        this.recipes = recipes;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "RecipeList{" +
                "count=" + count +
                ", recipes=" + recipes +
                '}';
    }
}
