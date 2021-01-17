package com.example.botik.model;

import com.google.gson.annotations.SerializedName;

public class ModelPay {
    @SerializedName("title")
    String title;
    @SerializedName("image")
    String image;
    @SerializedName("link")
    String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
