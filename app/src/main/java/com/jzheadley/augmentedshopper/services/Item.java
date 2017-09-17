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


    public Item() {
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getLowestRecordedPrice() {
        return lowestRecordedPrice;
    }

    public void setLowestRecordedPrice(Integer lowestRecordedPrice) {
        this.lowestRecordedPrice = lowestRecordedPrice;
    }

    public Double getHighestRecordedPrice() {
        return highestRecordedPrice;
    }

    public void setHighestRecordedPrice(Double highestRecordedPrice) {
        this.highestRecordedPrice = highestRecordedPrice;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getElid() {
        return elid;
    }

    public void setElid(String elid) {
        this.elid = elid;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ean='" + ean + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", upc='" + upc + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", dimension='" + dimension + '\'' +
                ", weight='" + weight + '\'' +
                ", currency='" + currency + '\'' +
                ", lowestRecordedPrice=" + lowestRecordedPrice +
                ", highestRecordedPrice=" + highestRecordedPrice +
                ", images=" + images +
                ", offers=" + offers +
                ", asin='" + asin + '\'' +
                ", elid='" + elid + '\'' +
                '}';
    }
}
