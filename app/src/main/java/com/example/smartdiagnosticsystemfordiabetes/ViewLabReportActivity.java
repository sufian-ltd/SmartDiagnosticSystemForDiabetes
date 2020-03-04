package com.example.smartdiagnosticsystemfordiabetes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ViewLabReportActivity extends AppCompatActivity {

    String testName;
    LabTestEntity report;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lab_report);
        imageView=findViewById(R.id.ivImage);
        testName=getIntent().getStringExtra("testName");
        report=(LabTestEntity) getIntent().getSerializableExtra("report");
        init();
    }

    private void init() {
        if (testName.equals(Utils.labTestNames[0])){
            imageView.setImageBitmap(getBitmapByEncodedString(report.getBiochemistry()));
        }
        else if (testName.equals(Utils.labTestNames[1])){
            imageView.setImageBitmap(getBitmapByEncodedString(report.getImmunology()));
        }
        else if (testName.equals(Utils.labTestNames[2])){
            imageView.setImageBitmap(getBitmapByEncodedString(report.getBlood()));
        }
        else if (testName.equals(Utils.labTestNames[3])){
            imageView.setImageBitmap(getBitmapByEncodedString(report.getHormone()));
        }
        else if (testName.equals(Utils.labTestNames[4])){
            imageView.setImageBitmap(getBitmapByEncodedString(report.getDigestiveSystem()));
        }
        else if (testName.equals(Utils.labTestNames[5])){
            imageView.setImageBitmap(getBitmapByEncodedString(report.getStressAdrenalFatigue()));
        }
        else if (testName.equals(Utils.labTestNames[6])){
            imageView.setImageBitmap(getBitmapByEncodedString(report.getMicrobiology()));
        }
        else if (testName.equals(Utils.labTestNames[7])){
            imageView.setImageBitmap(getBitmapByEncodedString(report.getMineralDeficiency()));
        }
        else if (testName.equals(Utils.labTestNames[8])){
            imageView.setImageBitmap(getBitmapByEncodedString(report.getEco()));
        }
        else if (testName.equals(Utils.labTestNames[9])){
            imageView.setImageBitmap(getBitmapByEncodedString(report.getEcg()));
        }

    }

    public static Bitmap getBitmapByEncodedString(String base64String) {
        byte[] decodedString = Base64.decode(base64String, Base64.NO_WRAP);
        InputStream input=new ByteArrayInputStream(decodedString);
        Bitmap bitmap = BitmapFactory.decodeStream(input);
        return bitmap;
    }
}
