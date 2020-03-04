package com.example.smartdiagnosticsystemfordiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    String email,password;
    UserEntity userEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        email=getIntent().getStringExtra("email");
        password=getIntent().getStringExtra("password");
        getUser();
    }

    private void getUser(){
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<UserEntity>> call=apiInterface.getUser(email,password);
        call.enqueue(new Callback<List<UserEntity>>() {
            @Override
            public void onResponse(Call<List<UserEntity>> call, Response<List<UserEntity>> response) {
                userEntity =response.body().get(0);
            }

            @Override
            public void onFailure(Call<List<UserEntity>> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "Connection failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void newProgressReport(View view) {
        Intent intent=new Intent(DashboardActivity.this,ProgressReportActivity.class);
        intent.putExtra("user",userEntity);
        startActivity(intent);
    }

    public void progressReport(View view) {
        Intent intent=new Intent(DashboardActivity.this,PreviousProgressReportListActivity.class);
        intent.putExtra("user",userEntity);
        startActivity(intent);
    }

    public void foodPlan(View view) {
        Intent intent=new Intent(DashboardActivity.this,FoodPlanActivity.class);
        intent.putExtra("user",userEntity);
        startActivity(intent);
    }

    public void labTest(View view) {
        Intent intent=new Intent(DashboardActivity.this,LabTestActivity.class);
        intent.putExtra("user",userEntity);
        startActivity(intent);
    }

    public void prescription(View view) {
        Intent intent=new Intent(DashboardActivity.this,PrescriptionListActivity.class);
        intent.putExtra("user",userEntity);
        startActivity(intent);
    }

    public void appointment(View view) {
        Intent intent=new Intent(DashboardActivity.this,SelectDoctorActivity.class);
        intent.putExtra("user",userEntity);
        startActivity(intent);
    }

    public void infoClick(View view) {
        Intent intent=new Intent(DashboardActivity.this,DiabeticInformationActivity.class);
        startActivity(intent);
    }
}