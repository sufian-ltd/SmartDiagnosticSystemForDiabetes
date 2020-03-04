package com.example.smartdiagnosticsystemfordiabetes;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserEntity implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("email")
    private String email;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getBp() {
        return bp;
    }

    public int getWeight() {
        return weight;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    @SerializedName("password")
    private String password;
    @SerializedName("name")
    private String name;
    @SerializedName("gender")
    private String gender;
    @SerializedName("age")
    private int age;
    @SerializedName("bp")
    private String bp;
    @SerializedName("weight")
    private int weight;
    @SerializedName("contact")
    private String contact;
    @SerializedName("address")
    private String address;
}
