package com.example.smartdiagnosticsystemfordiabetes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class LabTestResultActivity extends AppCompatActivity {

    String tbName="";
    int testId;
    ListView listView;
    List<BiochemistryTestEntity> list;
    Button btnHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_result);
        listView=findViewById(R.id.listView);
        btnHeading=findViewById(R.id.btnHeading);
        tbName=getIntent().getStringExtra("tbName");
        testId=getIntent().getIntExtra("testId",-1);
        setAdapter();
    }

    public void setAdapter(){
        BiochemistryReport biochemistryReport=new BiochemistryReport();
        biochemistryReport.getResult(tbName,testId);
        Toast.makeText(this, "size = "+biochemistryReport.getList().size(), Toast.LENGTH_SHORT).show();
//        String str[]=biochemistryReport.getStr();
//        ArrayAdapter<String> adapter =new ArrayAdapter<String>(LabTestResultActivity.this,
//                android.R.layout.simple_list_item_1,str);
//        listView.setAdapter(adapter);
//        String temp[]=tbName.split("_");
        //btnHeading.setText(temp[0]+" Test Report Result");
    }
}
