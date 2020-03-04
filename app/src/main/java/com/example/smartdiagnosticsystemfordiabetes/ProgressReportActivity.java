package com.example.smartdiagnosticsystemfordiabetes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgressReportActivity extends AppCompatActivity {

    EditText etWeight,etBloodNo,etSuger,etAlbumin,etAcitone,etHbA1c,etBp1,etGb1,
        etBp2,etGb2;
    Button btnSave;
    UserEntity userEntity;
    ProgressReportEntity entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_report);
        etWeight=findViewById(R.id.etWeight);
        etBloodNo=findViewById(R.id.etBloodNo);
        etSuger=findViewById(R.id.etSuger);
        etAlbumin=findViewById(R.id.etAlbumin);
        etAcitone=findViewById(R.id.etACitone);
        etHbA1c=findViewById(R.id.etHba1c);
        etBp1=findViewById(R.id.etBp1);
        etGb1=findViewById(R.id.etGb1);
        etBp2=findViewById(R.id.etBp2);
        etGb2=findViewById(R.id.etGb2);
        btnSave=findViewById(R.id.btnSave);
        userEntity=(UserEntity) getIntent().getSerializableExtra("user");
        entity=(ProgressReportEntity) getIntent().getSerializableExtra("entity");
        if(entity!=null){
            btnSave.setVisibility(View.GONE);
            setData();
            enableDisable(false);
        }
        else
            enableDisable(true);
    }

    public void setData(){
        etWeight.setText(entity.getWeight()+" kg");
        etBloodNo.setText(entity.getBlood());
        etSuger.setText(entity.getSuger());
        etAlbumin.setText(entity.getAlbumin());
        etAcitone.setText(entity.getAcitone());
        etHbA1c.setText(entity.getHbA1c());
        etBp1.setText(entity.getBp1());
        etGb1.setText(entity.getGb1());
        etBp2.setText(entity.getBp2());
        etGb2.setText(entity.getGb2());
    }

    public void enableDisable(boolean yes){
        etWeight.setEnabled(yes);
        etBloodNo.setEnabled(yes);
        etSuger.setEnabled(yes);
        etAlbumin.setEnabled(yes);
        etAcitone.setEnabled(yes);
        etHbA1c.setEnabled(yes);
        etBp1.setEnabled(yes);
        etGb1.setEnabled(yes);
        etBp2.setEnabled(yes);
        etGb2.setEnabled(yes);
    }

    public void saveReport(View view) {
        int patientId=userEntity!=null?userEntity.getId():1;
        String weight=etWeight.getText().toString();
        String blood=etBloodNo.getText().toString();
        String suger=etSuger.getText().toString();
        String albumin=etAlbumin.getText().toString();
        String acitone=etAcitone.getText().toString();
        String hbA1c=etHbA1c.getText().toString();
        String bp1=etBp1.getText().toString();
        String gb1=etGb1.getText().toString();
        String bp2=etBp2.getText().toString();
        String gb2=etGb2.getText().toString();
        String date=getDate();
        if(patientId!=0 && !weight.equals("") && !blood.equals("") && !suger.equals("") && !albumin.equals("") &&
            !acitone.equals("") && !hbA1c.equals("") && !bp1.equals("") && !gb1.equals("") && !bp2.equals("") &&
            !gb2.equals("")){
            ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
            Call<ServerResponse> call=apiInterface.saveProgressReport(patientId,weight,blood,suger,albumin,acitone,hbA1c,
                bp1,gb1,bp2,gb2,date);
            call.enqueue(new Callback<ServerResponse>() {
                @Override
                public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                    ServerResponse serverResponse=response.body();
                    String message=serverResponse.getResponse();
                    if(message.equals("inserted")){
                        Toast.makeText(ProgressReportActivity.this, "Progress Report Successfully Saved", Toast.LENGTH_SHORT).show();
                    }
                    else if(message.equals("not inserted")){
                        Toast.makeText(ProgressReportActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ServerResponse> call, Throwable t) {
                    Toast.makeText(ProgressReportActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            Toast.makeText(this, "Please Fill All..!!", Toast.LENGTH_SHORT).show();
        }
    }
    public String getDate()
    {
        Calendar cal;
        cal = Calendar.getInstance();
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat();
        return sdf.format(cal.getTime());
    }
}
