package com.example.smartdiagnosticsystemfordiabetes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LabTestEntity implements Serializable{

    private static final long serialVersionUID=1L;

    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getPrecriptionId() {
        return precriptionId;
    }

    public String getBiochemistry() {
        return biochemistry;
    }

    public String getImmunology() {
        return immunology;
    }

    public String getBlood() {
        return blood;
    }

    public String getHormone() {
        return hormone;
    }

    public String getDigestiveSystem() {
        return digestiveSystem;
    }

    public String getStressAdrenalFatigue() {
        return stressAdrenalFatigue;
    }

    public String getMicrobiology() {
        return microbiology;
    }

    public String getMineralDeficiency() {
        return mineralDeficiency;
    }

    public String getEco() {
        return eco;
    }

    public String getEcg() {
        return ecg;
    }

    public String getDate() {
        return date;
    }

    @SerializedName("id")
    private int id;
    @SerializedName("patientId")
    private int patientId;
    @SerializedName("precriptionId")
    private int precriptionId;
    @SerializedName("biochemistry")
    private String biochemistry;
    @SerializedName("immunology")
    private String immunology;
    @SerializedName("blood")
    private String blood;
    @SerializedName("hormone")
    private String hormone;
    @SerializedName("digestiveSystem")
    private String digestiveSystem;
    @SerializedName("stressAdrenalFatigue")
    private String stressAdrenalFatigue;
    @SerializedName("microbiology")
    private String microbiology;
    @SerializedName("mineralDeficiency")
    private String mineralDeficiency;
    @SerializedName("eco")
    private String eco;
    @SerializedName("ecg")
    private String ecg;
    @SerializedName("date")
    private String date;
}
