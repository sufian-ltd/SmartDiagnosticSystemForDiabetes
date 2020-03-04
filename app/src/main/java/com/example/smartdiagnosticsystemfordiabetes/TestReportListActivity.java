package com.example.smartdiagnosticsystemfordiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TestReportListActivity extends AppCompatActivity {

    ListView listView;
    String tbNames[]={
            "biochemistry_test_tb"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_report_list);
        listView=findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>=tbNames.length){
                    Toast.makeText(TestReportListActivity.this, "No Lab Test Found.!!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(TestReportListActivity.this,PreviousTestReportListActivity.class);
                    intent.putExtra("tbName",tbNames[i]);
                    startActivity(intent);
                }
            }
        });
        getTestReportList();
    }
    private void getTestReportList(){
        String str[]={
                "Biochemistry Test Report Result",
                "Microbiology Test Report Result",
                "Biochemistry Test Report Result",
                "Biochemistry Test Report Result",
                "Biochemistry Test Report Result",
                "Biochemistry Test Report Result",
                "Biochemistry Test Report Result",
                "Biochemistry Test Report Result",
                "Biochemistry Test Report Result",
                "Biochemistry Test Report Result",
                "Biochemistry Test Report Result"
        };
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(TestReportListActivity.this,
                android.R.layout.simple_list_item_1,str);
        listView.setAdapter(adapter);
    }
}
