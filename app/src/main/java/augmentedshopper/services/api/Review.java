package augmentedshopper.services.api;

import java.util.ArrayList;
import java.util.List;

public class Review {
    private float rating;
    private String content;

    public Review(int rating, String content) {
        this.rating = rating;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review{" +
                "rating=" + rating +
                ", content='" + content + '\'' +
                '}';
    }

    public Review() {
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
