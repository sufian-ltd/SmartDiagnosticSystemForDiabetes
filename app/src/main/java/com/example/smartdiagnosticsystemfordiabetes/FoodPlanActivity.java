package com.example.smartdiagnosticsystemfordiabetes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodPlanActivity extends AppCompatActivity {

    UserEntity userEntity;
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_plan);
        userEntity=(UserEntity) getIntent().getSerializableExtra("user");
        getFoodPlan();
        pdfView=findViewById(R.id.pdfView);
    }

    private void getFoodPlan() {
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<List<FoodPlanEntity>> call=apiInterface.getFoodPlan(userEntity.getId());
        call.enqueue(new Callback<List<FoodPlanEntity>>() {
            @Override
            public void onResponse(Call<List<FoodPlanEntity>> call, Response<List<FoodPlanEntity>> response) {
                FoodPlanEntity foodPlanEntity=response.body().get(0);
                loadFoodPlan(foodPlanEntity.getPlan());
            }

            @Override
            public void onFailure(Call<List<FoodPlanEntity>> call, Throwable t) {
                Toast.makeText(FoodPlanActivity.this, "Connection failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadFoodPlan(int plan){
        if(plan==1)
            pdfView.fromAsset("food_list_1.pdf").load();
        else if(plan==2)
            pdfView.fromAsset("food_list_2.pdf").load();
        else if(plan==3)
            pdfView.fromAsset("food_list_3.pdf").load();
        else if(plan==4)
            pdfView.fromAsset("food_list_4.pdf").load();
    }
}
