package com.example.smartdiagnosticsystemfordiabetes;

import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiochemistryReport {

    List<BiochemistryTestEntity> list;
    String str[];

    public void getResult(String tbName,int testId){
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<BiochemistryTestEntity>> call=apiInterface.getLabTestResult(tbName,testId);
        call.enqueue(new Callback<List<BiochemistryTestEntity>>() {
            @Override
            public void onResponse(Call<List<BiochemistryTestEntity>> call, Response<List<BiochemistryTestEntity>> response) {
                list=response.body();
                setAdapterValues();
            }

            @Override
            public void onFailure(Call<List<BiochemistryTestEntity>> call, Throwable t) {
            }
        });
    }
    public void setAdapterValues(){
        str=new String[list.size()];
        str[0]="Serum Electrolytes (Sodium(Na+)): "+list.get(0).getSena()+" mmol/L (Ref:136-145 mmol/L)";
        str[1]="Serum Electrolytes (Sodium(Na+)): "+list.get(0).getSek()+" mmol/L (Ref:3.5-5.0 mmol/L)";
        str[2]="Serum Electrolytes (Sodium(Na+)): "+list.get(0).getSecl()+" mmol/L (Ref:96-106 mmol/L)";
        str[3]="Serum Electrolytes (Sodium(Na+)): "+list.get(0).getSehco3()+" mmol/L (Ref:25-30 mmol/L)";
        str[4]="Serum Electrolytes (pH): "+list.get(0).getPh()+" (Ref:7.35-7.45)";
        str[5]="Serum Creatinine: "+list.get(0).getSercre()+" mg/dL (Ref: Male:0.4-1.4 Female:0.3-1.1)";
        str[6]="Serum Calcium: "+list.get(0).getSercal()+" mmol/L (Ref:2.25-2.62 mmol/L)";
        str[7]="Urine Protein/Creatinine Ratio(PCR): "+list.get(0).getPcr()+" (Ref: UC:90-300 UP:upto 11.9 mg/d:)";
        str[8]="CRP(C-Reactive Protein) with Titre: "+list.get(0).getCrp()+" mg/L (Ref:<5.0 mg/L)";
        str[9]="Serum Phosphorus(PO4): "+list.get(0).getPo4()+" mmol/L (Ref:0.81-1.58 mmol/L)";
        str[10]="Urine Creatinine: "+list.get(0).getUc()+" mg/dL";
        str[11]="Urine Protein: "+list.get(0).getUp()+" mg/dL";
        str[12]="Parathyroid Hormone(PTH): "+list.get(0).getPth()+" pg/ml (Ref:7-53 pg/ml)";
    }
    public String[] getStr(){
        return str;
    }
    public List<BiochemistryTestEntity> getList(){
        return list;
    }
}
