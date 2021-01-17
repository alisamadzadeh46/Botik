package com.example.botik.model;

import com.google.gson.annotations.SerializedName;

public class ModelUserInfo {
    @SerializedName("username")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
