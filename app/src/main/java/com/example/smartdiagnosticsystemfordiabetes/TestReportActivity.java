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

import java.util.ArrayList;
import java.util.List;

public class TestReportActivity extends AppCompatActivity {

    UserEntity userEntity;
    LabTestEntity report;
    ListView listView;
    Button btnHeading;
    List<String> testNames=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_report);
        btnHeading=findViewById(R.id.btnHeading);
        listView =findViewById(R.id.listView);
        report=(LabTestEntity) getIntent().getSerializableExtra("report");
        userEntity=(UserEntity) getIntent().getSerializableExtra("user");
        btnHeading.setText("Report Date : "+report.getDate());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(TestReportActivity.this,ViewLabReportActivity.class);
                intent.putExtra("report",report);
                intent.putExtra("testName",testNames.get(i));
                startActivity(intent);
            }
        });
        setAdapter();
    }

    private void setAdapter(){
        if(!report.getBiochemistry().isEmpty()) {
//            str[index] = report.getBiochemistry();
            testNames.add(Utils.labTestNames[0]);
        }
        if(!report.getImmunology().isEmpty()) {
//            str[index] = report.getImmunology();
            testNames.add(Utils.labTestNames[1]);
        }
        if(!report.getBlood().isEmpty()) {
//            str[index] = report.getBlood();
            testNames.add(Utils.labTestNames[2]);
        }
        if(!report.getHormone().isEmpty()) {
//            str[index] = report.getHormone();
            testNames.add(Utils.labTestNames[3]);
        }
        if(!report.getDigestiveSystem().isEmpty()) {
//            str[index] = report.getDigestiveSystem();
            testNames.add(Utils.labTestNames[4]);
        }
        if(!report.getStressAdrenalFatigue().isEmpty()) {
//            str[index] = report.getStressAdrenalFatigue();
            testNames.add(Utils.labTestNames[5]);
        }
        if(!report.getMicrobiology().isEmpty()) {
//            str[index] = report.getMicrobiology();
            testNames.add(Utils.labTestNames[6]);
        }
        if(!report.getMineralDeficiency().isEmpty()) {
            testNames.add(Utils.labTestNames[7]);
        }
        if(!report.getEco().isEmpty()) {
//            str[index] = report.getEco();
            testNames.add(Utils.labTestNames[8]);
        }
        if(!report.getEcg().isEmpty()) {
//            str[index] = report.getEcg();
            testNames.add(Utils.labTestNames[9]);
        }
        List<ListItemEntity> listItemEntities=new ArrayList<>();
        for (int i=0;i<testNames.size();i++){
            ListItemEntity listItemEntity=new ListItemEntity((i+1)+". "+testNames.get(i)+" Report","(A soft copy found!)");
            listItemEntities.add(listItemEntity);
        }
        ListAdapter adapter=new ListAdapter(this,listItemEntities);
        listView.setAdapter(adapter);
    }
}
