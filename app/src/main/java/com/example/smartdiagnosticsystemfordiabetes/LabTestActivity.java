package com.example.smartdiagnosticsystemfordiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LabTestActivity extends AppCompatActivity {

    ListView listView;
    UserEntity userEntity;
    List<LabTestEntity> list;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
        listView=findViewById(R.id.listView);
        userEntity=(UserEntity) getIntent().getSerializableExtra("user");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(LabTestActivity.this,TestReportActivity.class);
                intent.putExtra("report",list.get(i));
                intent.putExtra("user",userEntity);
                startActivity(intent);
            }
        });
        getAllLabTest();
    }

    private void getAllLabTest() {
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<LabTestEntity>> call=apiInterface.getAllLabTest(userEntity.getId());
        call.enqueue(new Callback<List<LabTestEntity>>() {
            @Override
            public void onResponse(Call<List<LabTestEntity>> call, Response<List<LabTestEntity>> response) {
                list=response.body();
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<LabTestEntity>> call, Throwable t) {
                Toast.makeText(LabTestActivity.this, "Connection failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(){
        List<ListItemEntity> listItemEntities=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            ListItemEntity listItemEntity=new ListItemEntity((i+1)+". Lab Test Report (Check)","Date : "+list.get(i).getDate());
            listItemEntities.add(listItemEntity);
        }
        ListAdapter adapter=new ListAdapter(this,listItemEntities);
        listView.setAdapter(adapter);
    }
}
