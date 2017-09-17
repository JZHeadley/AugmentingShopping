package augmentedshopper.services.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sean on 9/16/17.
 */

public class Recipe {
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("f2f_url")
    @Expose
    private String f2fUrl;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("source_url")
    @Expose
    private String sourceUrl;
    @SerializedName("recipe_id")
    @Expose
    private String recipeId;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("social_rank")
    @Expose
    private Double socialRank;
    @SerializedName("publisher_url")
    @Expose
    private String publisherUrl;

    public Recipe() {
    }

    public Recipe(String publisher, String f2fUrl, String title, String sourceUrl, String recipeId, String imageUrl, Double socialRank, String publisherUrl) {
        this.publisher = publisher;
        this.f2fUrl = f2fUrl;
        this.title = title;
        this.sourceUrl = sourceUrl;
        this.recipeId = recipeId;
        this.imageUrl = imageUrl;
        this.socialRank = socialRank;
        this.publisherUrl = publisherUrl;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getF2fUrl() {
        return f2fUrl;
    }

    public void setF2fUrl(String f2fUrl) {
        this.f2fUrl = f2fUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getSocialRank() {
        return socialRank;
    }

    public void setSocialRank(Double socialRank) {
        this.socialRank = socialRank;
    }

    public String getPublisherUrl() {
        return publisherUrl;
    }

    public void setPublisherUrl(String publisherUrl) {
        this.publisherUrl = publisherUrl;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "publisher='" + publisher + '\'' +
                ", f2fUrl='" + f2fUrl + '\'' +
                ", title='" + title + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", recipeId='" + recipeId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", socialRank=" + socialRank +
                ", publisherUrl='" + publisherUrl + '\'' +
                '}';
    }
}