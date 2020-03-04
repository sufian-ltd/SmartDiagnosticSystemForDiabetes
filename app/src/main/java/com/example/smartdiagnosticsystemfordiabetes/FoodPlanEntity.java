package com.example.smartdiagnosticsystemfordiabetes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FoodPlanEntity implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("patientId")
    private int patientId;
    @SerializedName("plan")
    private int plan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }
}
