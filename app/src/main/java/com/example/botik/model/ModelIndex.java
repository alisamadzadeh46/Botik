package com.example.botik.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

public class ModelIndex {
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
    public String getTozih() {
        return tozih;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTozih(String tozih) {
        this.tozih = tozih;
    }

    public String getIdpost() {
        return idpost;
    }

    public void setIdpost(String idpost) {
        this.idpost = idpost;
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

    @BindingAdapter("image")
    static public void image(ImageView view, String url){
        Glide.with(view).load(url).into(view);
    }
}
