package com.example.smartdiagnosticsystemfordiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DiabeticInformationActivity extends AppCompatActivity {

    TextView tvWhatIsDiabetes,tvFastFoodInforgraphics,tvIrishFood,tvDiabetesYourHeart,tvHealthyEating,
            tvSignificieant,tvHeartDiseasesfacts,tvInfoGraphic,tvRed,tvSalty,tvheart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetic_information);
        tvWhatIsDiabetes=findViewById(R.id.tvWhatIsDiabetes);
        tvFastFoodInforgraphics=findViewById(R.id.tvFastFoodInforgraphics);
        tvIrishFood=findViewById(R.id.tvIrishFood);
        tvDiabetesYourHeart=findViewById(R.id.tvDiabetesYourHeart);
        tvHealthyEating=findViewById(R.id.tvHealthyEating);
        tvSignificieant=findViewById(R.id.tvSignificieant);
        tvHeartDiseasesfacts=findViewById(R.id.tvHeartDiseasesfacts);
        tvInfoGraphic=findViewById(R.id.tvInfoGraphic);
        tvRed=findViewById(R.id.tvRed);
        tvSalty=findViewById(R.id.tvSalty);
        tvheart=findViewById(R.id.tvheart);
        tvWhatIsDiabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("aboutdiabetes.pdf");
            }
        });
        tvFastFoodInforgraphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("fastfoodinforgraphics.pdf");
            }
        });
        tvIrishFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("irishfood.pdf");
            }
        });
        tvDiabetesYourHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("heartdaibetesfact.pdf");
            }
        });
        tvHealthyEating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("healtyplatefish.pdf");
            }
        });
        tvSignificieant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("thesignificiant.pdf");
            }
        });
        tvHeartDiseasesfacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("heartdiseaseinforgraphics.pdf");
            }
        });
        tvInfoGraphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("inforgraphics.pdf");
            }
        });
        tvRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("earredfacts.pdf");
            }
        });
        tvSalty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("saltykids.pdf");
            }
        });
        tvheart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPdf("hearthealtyfood.pdf");
            }
        });

    }

    private void openPdf(String name){
        Intent intent=new Intent(DiabeticInformationActivity.this,PdfActivity.class);
        intent.putExtra("pdfName",name);
        startActivity(intent);
    }
}
