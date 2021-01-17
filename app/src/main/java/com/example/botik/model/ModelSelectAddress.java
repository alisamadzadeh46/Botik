package com.example.botik.model;

import com.google.gson.annotations.SerializedName;

public class ModelSelectAddress {
    @SerializedName("id")
    String id;
    @SerializedName("token")
    String token;
    @SerializedName("address")
    String address;
    @SerializedName("codeposti")
    String codeposti;
    @SerializedName("phone")
    String phone;
    @SerializedName("phonesabet")
    String phonesabet;

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhonesabet() {
        return phonesabet;
    }

    public void setPhonesabet(String phonesabet) {
        this.phonesabet = phonesabet;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCodeposti() {
        return codeposti;
    }

    public void setCodeposti(String codeposti) {
        this.codeposti = codeposti;
    }
}
