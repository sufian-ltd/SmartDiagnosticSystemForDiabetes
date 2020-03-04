package com.example.smartdiagnosticsystemfordiabetes;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class PrescriptionListActivity extends AppCompatActivity {

    ListView listView;
    List<PrescriptionEntity> list;
    UserEntity userEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_list);
        listView=findViewById(R.id.listView);
        userEntity=(UserEntity) getIntent().getSerializableExtra("user");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(PrescriptionListActivity.this,PrescriptionDataActivity.class);
                intent.putExtra("prescription",list.get(i));
                intent.putExtra("user",userEntity);
                startActivity(intent);
            }
        });
        getPrescriptionList();
    }
    private void getPrescriptionList(){
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<PrescriptionEntity>> call=apiInterface.getAllPrescription(userEntity.getId());
        call.enqueue(new Callback<List<PrescriptionEntity>>() {
            @Override
            public void onResponse(Call<List<PrescriptionEntity>> call, Response<List<PrescriptionEntity>> response) {
                list=response.body();
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<PrescriptionEntity>> call, Throwable t) {
                Toast.makeText(PrescriptionListActivity.this, "Connection failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setAdapter(){
        List<ListItemEntity> listItemEntities=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            ListItemEntity listItemEntity=new ListItemEntity("Date : "+list.get(i).getDate(),"Next Date To Meet : "+list.get(i).getNextDate());
            listItemEntities.add(listItemEntity);
        }
        ListAdapter adapter=new ListAdapter(this,listItemEntities);
        listView.setAdapter(adapter);
    }
}