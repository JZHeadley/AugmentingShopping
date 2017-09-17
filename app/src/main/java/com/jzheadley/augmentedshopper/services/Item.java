package com.jzheadley.augmentedshopper.services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.jzheadley.augmentedshopper.services.api.Offer;

import java.util.List;

public class Item {

    @SerializedName("ean")
    @Expose
    public String ean;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("upc")
    @Expose
    public String upc;
    @SerializedName("brand")
    @Expose
    public String brand;
    @SerializedName("model")
    @Expose
    public String model;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("size")
    @Expose
    public String size;
    @SerializedName("dimension")
    @Expose
    public String dimension;
    @SerializedName("weight")
    @Expose
    public String weight;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("lowest_recorded_price")
    @Expose
    public Integer lowestRecordedPrice;
    @SerializedName("highest_recorded_price")
    @Expose
    public Double highestRecordedPrice;
    @SerializedName("images")
    @Expose
    public List<String> images = null;
    @SerializedName("offers")
    @Expose
    public List<Offer> offers = null;
    @SerializedName("asin")
    @Expose
    public String asin;
    @SerializedName("elid")
    @Expose
    public String elid;

}
