package com.example.botik.model;

import com.google.gson.annotations.SerializedName;

public class ModelGetCart {
    @SerializedName("idpost")
    String idpost;
    @SerializedName("image")
    String image;
    @SerializedName("made")
    String made;
    @SerializedName("price")
    String price;
    @SerializedName("tozih")
    String tozih;
    @SerializedName("name")
    String name;
    @SerializedName("id")
    String id;
    @SerializedName("token")
    String token;
    @SerializedName("idproduct")
    String idproduct;
    @SerializedName("count")
    String count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTozih() {
        return tozih;
    }

    public void setTozih(String tozih) {
        this.tozih = tozih;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdpost() {
        return idpost;
    }

    public void setIdpost(String idpost) {
        this.idpost = idpost;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
