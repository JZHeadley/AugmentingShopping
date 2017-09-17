package com.jzheadley.augmentedshopper.services.api;

public class Review {
    private float rating;
    private String content;

    public Review(int rating, String content) {
        this.rating = rating;
        this.content = content;
    }

    public Review() {
    }

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", content='" + content + '\'' +
                '}';
    }

    public float getRating() {

        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
