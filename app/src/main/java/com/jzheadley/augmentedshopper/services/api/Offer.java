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

    public Offer() {
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getUpdatedT() {
        return updatedT;
    }

    public void setUpdatedT(Integer updatedT) {
        this.updatedT = updatedT;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "merchant='" + merchant + '\'' +
                ", domain='" + domain + '\'' +
                ", title='" + title + '\'' +
                ", currency='" + currency + '\'' +
                ", listPrice='" + listPrice + '\'' +
                ", price=" + price +
                ", shipping='" + shipping + '\'' +
                ", condition='" + condition + '\'' +
                ", availability='" + availability + '\'' +
                ", link='" + link + '\'' +
                ", updatedT=" + updatedT +
                '}';
    }
}
