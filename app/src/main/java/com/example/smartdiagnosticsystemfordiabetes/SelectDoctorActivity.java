package com.example.smartdiagnosticsystemfordiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectDoctorActivity extends AppCompatActivity {

    ListView listView;
    List<DoctorEntity> list;
    UserEntity user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_doctor_activty);
        listView=findViewById(R.id.listView);
        user=(UserEntity) getIntent().getSerializableExtra("user");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(SelectDoctorActivity.this,AppointmentActivity.class);
                intent.putExtra("doctor",list.get(i));
                intent.putExtra("user",user);
                finish();
                startActivity(intent);
            }
        });
        getDoctors();
    }

    private void getDoctors(){
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<DoctorEntity>> call=apiInterface.getDoctors();
        call.enqueue(new Callback<List<DoctorEntity>>() {
            @Override
            public void onResponse(Call<List<DoctorEntity>> call, Response<List<DoctorEntity>> response) {
                list =response.body();
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<DoctorEntity>> call, Throwable t) {
                Toast.makeText(SelectDoctorActivity.this, "Connection failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setAdapter(){
        DoctorAdapter adapter=new DoctorAdapter(this,list);
        listView.setAdapter(adapter);
    }
}
