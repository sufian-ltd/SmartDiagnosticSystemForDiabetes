package com.example.smartdiagnosticsystemfordiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreviousTestReportListActivity extends AppCompatActivity {

    ListView listView;
    List<LabTestEntity> list;
    String tbName="";
    Button btnHeading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_test_report_list);
        listView=findViewById(R.id.listView);
        btnHeading=findViewById(R.id.btnHeading);
        tbName=getIntent().getStringExtra("tbName");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(PreviousTestReportListActivity.this,LabTestResultActivity.class);
                intent.putExtra("tbName",tbName);
                intent.putExtra("testId",list.get(i).getId());
                startActivity(intent);
            }
        });
        getTestReportList();
    }
    private void getTestReportList(){
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<LabTestEntity>> call=apiInterface.getDatesByTbName(tbName);
        call.enqueue(new Callback<List<LabTestEntity>>() {
            @Override
            public void onResponse(Call<List<LabTestEntity>> call, Response<List<LabTestEntity>> response) {
                list=response.body();
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<LabTestEntity>> call, Throwable t) {
                Toast.makeText(PreviousTestReportListActivity.this, "Connection failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setAdapter(){
        String temp[]=tbName.split("_");
        String str[]=new String[list.size()];
        for(int i=0;i<list.size();i++){
            str[i]="Lab Report On: "+list.get(i).getDate();
        }
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(PreviousTestReportListActivity.this,
                android.R.layout.simple_list_item_1,str);
        listView.setAdapter(adapter);
        btnHeading.setText(temp[0]+" Lab Test Report List");
    }
}
