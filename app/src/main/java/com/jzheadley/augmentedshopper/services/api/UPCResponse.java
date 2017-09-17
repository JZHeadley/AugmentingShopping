package com.jzheadley.augmentedshopper.services.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class UPCResponse {
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("offset")
    @Expose
    public Integer offset;
    @SerializedName("items")
    @Expose
    public List<Item> items = null;

    public UPCResponse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "UPCResponse{" +
                "code='" + code + '\'' +
                ", total=" + total +
                ", offset=" + offset +
                ", items=" + items +
                '}';
    }
}
