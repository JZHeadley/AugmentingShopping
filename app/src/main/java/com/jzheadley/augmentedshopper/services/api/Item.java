package com.jzheadley.augmentedshopper.services.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sean on 9/17/17.
 */

public class Item {

    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("htmlTitle")
    @Expose
    public String htmlTitle;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("displayLink")
    @Expose
    public String displayLink;
    @SerializedName("snippet")
    @Expose
    public String snippet;
    @SerializedName("htmlSnippet")
    @Expose
    public String htmlSnippet;
    @SerializedName("cacheId")
    @Expose
    public String cacheId;
    @SerializedName("mime")
    @Expose
    public String mime;
    @SerializedName("fileFormat")
    @Expose
    public String fileFormat;
    @SerializedName("formattedUrl")
    @Expose
    public String formattedUrl;
    @SerializedName("htmlFormattedUrl")
    @Expose
    public String htmlFormattedUrl;
    @SerializedName("pagemap")
    @Expose
    public Pagemap pagemap;
    @SerializedName("labels")
    @Expose
    public List<Label> labels = null;
    @SerializedName("image")
    @Expose
    public Image image;

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return image.getThumbLink();
    }


}
