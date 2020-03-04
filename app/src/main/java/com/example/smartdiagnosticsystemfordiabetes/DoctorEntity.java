package com.example.smartdiagnosticsystemfordiabetes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DoctorEntity implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @SerializedName("available")
    private String available;
    @SerializedName("qualification")
    private String qualification;
    @SerializedName("fee")
    private String fee;
}
