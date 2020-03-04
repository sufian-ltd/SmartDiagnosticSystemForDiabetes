package com.example.smartdiagnosticsystemfordiabetes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BiochemistryTestEntity implements Serializable{

    public String getSena() {
        return sena;
    }

    public void setSena(String sena) {
        this.sena = sena;
    }

    public String getSek() {
        return sek;
    }

    public void setSek(String sek) {
        this.sek = sek;
    }

    public String getSecl() {
        return secl;
    }

    public void setSecl(String secl) {
        this.secl = secl;
    }

    public String getSehco3() {
        return sehco3;
    }

    public void setSehco3(String sehco3) {
        this.sehco3 = sehco3;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getSercre() {
        return sercre;
    }

    public void setSercre(String sercre) {
        this.sercre = sercre;
    }

    public String getSercal() {
        return sercal;
    }

    public void setSercal(String sercal) {
        this.sercal = sercal;
    }

    public String getPcr() {
        return pcr;
    }

    public void setPcr(String pcr) {
        this.pcr = pcr;
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public String getPo4() {
        return po4;
    }

    public void setPo4(String po4) {
        this.po4 = po4;
    }

    public String getUc() {
        return uc;
    }

    public void setUc(String uc) {
        this.uc = uc;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getPth() {
        return pth;
    }

    public void setPth(String pth) {
        this.pth = pth;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    private static final long serialVersionUID=1L;

    @SerializedName("id")
    private int id;
    @SerializedName("sena")
    private String sena;
    @SerializedName("sek")
    private String sek;
    @SerializedName("secl")
    private String secl;
    @SerializedName("sehco3")
    private String sehco3;
    @SerializedName("ph")
    private String ph;
    @SerializedName("sercre")
    private String sercre;
    @SerializedName("sercal")
    private String sercal;
    @SerializedName("pcr")
    private  String pcr;
    @SerializedName("crp")
    private String crp;
    @SerializedName("po4")
    private String po4;
    @SerializedName("uc")
    private String uc;
    @SerializedName("up")
    private String up;
    @SerializedName("pth")
    private String pth;
    @SerializedName("date")
    private String Date;
}
