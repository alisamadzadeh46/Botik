package com.example.botik.model;

import com.google.gson.annotations.SerializedName;

public class CartCount {
    @SerializedName("count")
    String count;

    public String getCount() {
        return count;
    }
}
