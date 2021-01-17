package com.example.botik.model;

import com.google.gson.annotations.SerializedName;

public class ModelShowData {
    @SerializedName("address")
    String address;
    @SerializedName("codeposti")
    String codeposti;
    @SerializedName("phone")
    String phone;
    @SerializedName("phonesabet")
    String phonesabet;

    public String getPhonesabet() {
        return phonesabet;
    }

    public void setPhonesabet(String phonesabet) {
        this.phonesabet = phonesabet;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
