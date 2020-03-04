package com.example.smartdiagnosticsystemfordiabetes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppointmentActivity extends AppCompatActivity {

    DoctorEntity doctor;
    UserEntity user;
    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        tvMsg=findViewById(R.id.tvMsg);
        doctor=(DoctorEntity) getIntent().getSerializableExtra("doctor");
        user=(UserEntity) getIntent().getSerializableExtra("user");
        tvMsg.setText("Your Appointment is Successful.!!!\nPatient Name: "
                +user.getName()+"\nDoctor : "+doctor.getName()+"\nDoctor Available: "+doctor.getAvailable()
                +"\nAppointment Time: "+getDate());
        makeAppointment();
    }

    private void makeAppointment(){
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<ServerResponse> call=apiInterface.makeAppointment(user.getId(),doctor.getId(),user.getName(),doctor.getName(),getDate(),"pending");
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse serverResponse=response.body();
                String message=serverResponse.getResponse();
                if(message.equals("inserted")){
//                    Toast.makeText(AppointmentActivity.this, "Progress Report Successfully Saved", Toast.LENGTH_SHORT).show();
                }
                else if(message.equals("not inserted")){
//                    Toast.makeText(AppointmentActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
//                Toast.makeText(AppointmentActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getDate() {
        Calendar cal;
        cal = Calendar.getInstance();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat();
        return sdf.format(cal.getTime());
    }
}
