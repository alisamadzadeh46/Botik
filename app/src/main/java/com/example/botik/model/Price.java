package com.example.botik.model;

import com.google.gson.annotations.SerializedName;

public class Price {
    @SerializedName("price")
    String price;
    public String getPrice() {
        return price;
    }
}
