package com.example.botik.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelAddCart {
    @SerializedName("status")
    String status;
    @SerializedName("price")
    List<Price> price;

    public String getStatus() {
        return status;
    }

    public List<Price> getPrice() {
        return price;
    }
}
