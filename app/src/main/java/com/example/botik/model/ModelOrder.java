package com.example.botik.model;

import com.google.gson.annotations.SerializedName;

public class ModelOrder {
    @SerializedName("status")
    String status;
    @SerializedName("price")
    String price;
    @SerializedName("code")

    String code;
    @SerializedName("order")
    String order;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
