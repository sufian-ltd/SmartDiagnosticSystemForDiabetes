package com.example.smartdiagnosticsystemfordiabetes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProgressReportEntity implements Serializable{

    private static final long serialVersionUID=1L;
    @SerializedName("id")
    private int id;

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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getSuger() {
        return suger;
    }

    public void setSuger(String suger) {
        this.suger = suger;
    }

    public String getAlbumin() {
        return albumin;
    }

    public void setAlbumin(String albumin) {
        this.albumin = albumin;
    }

    public String getAcitone() {
        return acitone;
    }

    public void setAcitone(String acitone) {
        this.acitone = acitone;
    }

    public String getHbA1c() {
        return hbA1c;
    }

    public void setHbA1c(String hbA1c) {
        this.hbA1c = hbA1c;
    }

    public String getBp1() {
        return bp1;
    }

    public void setBp1(String bp1) {
        this.bp1 = bp1;
    }

    public String getGb1() {
        return gb1;
    }

    public void setGb1(String gb1) {
        this.gb1 = gb1;
    }

    public String getBp2() {
        return bp2;
    }

    public void setBp2(String bp2) {
        this.bp2 = bp2;
    }

    public String getGb2() {
        return gb2;
    }

    public void setGb2(String gb2) {
        this.gb2 = gb2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @SerializedName("patientId")
    private int patientId;
    @SerializedName("weight")
    private String weight;
    @SerializedName("blood")
    private String blood;
    @SerializedName("suger")
    private String suger;
    @SerializedName("albumin")
    private String albumin;
    @SerializedName("acitone")
    private String acitone;
    @SerializedName("hbA1c")
    private String hbA1c;
    @SerializedName("bp1")
    private String bp1;
    @SerializedName("gb1")
    private String gb1;
    @SerializedName("bp2")
    private String bp2;
    @SerializedName("gb2")
    private String gb2;
    @SerializedName("date")
    private String date;
}
