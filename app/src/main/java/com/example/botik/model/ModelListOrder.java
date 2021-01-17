package com.example.botik.model;

import com.google.gson.annotations.SerializedName;

public class ModelListOrder {
    @SerializedName("id")
    String id;
    @SerializedName("idaddress")
    String idaddress;
    @SerializedName("price")
    String price;
    @SerializedName("status")
    String status;
    @SerializedName("code_pardakht")
    String code_pardakht;
    @SerializedName("Authority")
    String Authority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(String idaddress) {
        this.idaddress = idaddress;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode_pardakht() {
        return code_pardakht;
    }

    public void setCode_pardakht(String code_pardakht) {
        this.code_pardakht = code_pardakht;
    }

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }
}
