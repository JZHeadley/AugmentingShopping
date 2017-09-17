package com.jzheadley.augmentedshopper.services.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("merchant")
    @Expose
    public String merchant;
    @SerializedName("domain")
    @Expose
    public String domain;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("list_price")
    @Expose
    public String listPrice;
    @SerializedName("price")
    @Expose
    public Double price;
    @SerializedName("shipping")
    @Expose
    public String shipping;
    @SerializedName("condition")
    @Expose
    public String condition;
    @SerializedName("availability")
    @Expose
    public String availability;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("updated_t")
    @Expose
    public Integer updatedT;

}
