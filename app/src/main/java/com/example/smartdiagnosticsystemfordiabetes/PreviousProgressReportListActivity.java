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

public class PreviousProgressReportListActivity extends AppCompatActivity {

    ListView listView;
    List<ProgressReportEntity> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_progress_report_list);
        listView=findViewById(R.id.listView);
        getProgressList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ProgressReportEntity entity=list.get(i);
                Intent intent=new Intent(PreviousProgressReportListActivity.this,ProgressReportActivity.class);
                intent.putExtra("entity",entity);
                startActivity(intent);
            }
        });
    }
    private void getProgressList(){
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<ProgressReportEntity>> call=apiInterface.getAllProgressReport();
        call.enqueue(new Callback<List<ProgressReportEntity>>() {
            @Override
            public void onResponse(Call<List<ProgressReportEntity>> call, Response<List<ProgressReportEntity>> response) {
                list=response.body();
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<ProgressReportEntity>> call, Throwable t) {
                Toast.makeText(PreviousProgressReportListActivity.this, "Connection failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setAdapter(){
        List<ListItemEntity> listItemEntities=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            ListItemEntity listItemEntity=new ListItemEntity("Progress Report On","Date : "+list.get(i).getDate());
            listItemEntities.add(listItemEntity);
        }
        ListAdapter adapter=new ListAdapter(this,listItemEntities);
        listView.setAdapter(adapter);
    }
}
