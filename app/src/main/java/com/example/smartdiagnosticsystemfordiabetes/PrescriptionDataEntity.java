package com.example.smartdiagnosticsystemfordiabetes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PrescriptionDataEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @SerializedName("id")
    private int id;
    @SerializedName("prescriptionId")
    private int prescriptionId;
    @SerializedName("medicine")
    private String medicine;

    public int getId() {
        return id;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public String getMedicine() {
        return medicine;
    }

    public String getTime1() {
        return time1;
    }

    public String getDay1() {
        return day1;
    }

    public String getEatTime() {
        return eatTime;
    }

    @SerializedName("time1")
    private String time1;
    @SerializedName("day1")
    private String day1;
    @SerializedName("eatTime")
    private String eatTime;
}
