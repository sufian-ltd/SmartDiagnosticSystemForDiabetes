   package com.example.smartdiagnosticsystemfordiabetes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrescriptionDataActivity extends AppCompatActivity {

    TextView tvDate,tvNextDate,tvProblem,tvAdvise;
    PrescriptionEntity prescription;
    UserEntity userEntity;
    List<PrescriptionDataEntity> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_data);
        tvDate=findViewById(R.id.tvDate);
        tvNextDate=findViewById(R.id.tvNextDate);
        tvProblem=findViewById(R.id.tvProblem);
        tvAdvise=findViewById(R.id.tvAdvise);
        listView=findViewById(R.id.listView);
        prescription=(PrescriptionEntity) getIntent().getSerializableExtra("prescription");
        userEntity=(UserEntity) getIntent().getSerializableExtra("user");
        init();
        getPrescriptionData();
    }

    private void getPrescriptionData() {
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<PrescriptionDataEntity>> call=apiInterface.getAllPrescriptionData(prescription.getId());
        call.enqueue(new Callback<List<PrescriptionDataEntity>>() {
            @Override
            public void onResponse(Call<List<PrescriptionDataEntity>> call, Response<List<PrescriptionDataEntity>> response) {
                list=response.body();
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<PrescriptionDataEntity>> call, Throwable t) {
                Toast.makeText(PrescriptionDataActivity.this, "Connection failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init(){
        tvDate.setText("Date:"+prescription.getDate());
        tvNextDate.setText("Next Meet:"+prescription.getNextDate());
        tvProblem.setText(prescription.getProblem());
        tvAdvise.setText(prescription.getAdvise());
    }

    private void setAdapter(){
        PrescriptionDataAdapter adapter=new PrescriptionDataAdapter(this,list);
        listView.setAdapter(adapter);
    }
}
