package augmentedshopper.services.api;

/**
 * Created by sean on 9/17/17.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultsList {

    @SerializedName("items")
    @Expose
    public List<Item> items = null;

    public List<Item> getItems() {
        return items;
    }
}

class Image {

    @SerializedName("contextLink")
    @Expose
    public String contextLink;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("byteSize")
    @Expose
    public Integer byteSize;
    @SerializedName("thumbnailLink")
    @Expose
    public String thumbnailLink;
    @SerializedName("thumbnailHeight")
    @Expose
    public Integer thumbnailHeight;
    @SerializedName("thumbnailWidth")
    @Expose
    public Integer thumbnailWidth;

    public String getThumbLink() {
        return thumbnailLink;
    }
}


class Key_ {

    @SerializedName("key")
    @Expose
    public String key;

}

class Label {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("displayName")
    @Expose
    public String displayName;
    @SerializedName("label_with_op")
    @Expose
    public String labelWithOp;

}

class Pagemap {

    @SerializedName("key")
    @Expose
    public List<Key_> key = null;

}