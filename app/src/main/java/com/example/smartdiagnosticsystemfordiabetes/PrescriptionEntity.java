package com.example.smartdiagnosticsystemfordiabetes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PrescriptionEntity implements Serializable {
    public int getId() {
        return id;
    }

    public String getProblem() {
        return problem;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDate() {
        return date;
    }

    public String getNextDate() {
        return nextDate;
    }

    public String getAdvise() {
        return advise;
    }

    private static final long serialVersionUID=1L;

    @SerializedName("id")
    private int id;
    @SerializedName("problem")
    private String problem;
    @SerializedName("patientId")
    private int patientId;
    @SerializedName("date")
    private String date;
    @SerializedName("nextDate")
    private String nextDate;
    @SerializedName("advise")
    private String advise;
}
