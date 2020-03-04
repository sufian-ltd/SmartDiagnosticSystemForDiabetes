package com.example.smartdiagnosticsystemfordiabetes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail,etPassword,etName,etAge,etBp,etWeight,etContact,etAddress;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etName=findViewById(R.id.etName);
        etAge=findViewById(R.id.etAge);
        etBp=findViewById(R.id.etBp);
        etWeight=findViewById(R.id.etWeight);
        etContact=findViewById(R.id.etContact);
        etAddress=findViewById(R.id.etAddress);
        rgGender=findViewById(R.id.rgGender);
    }

    private boolean isEmpty(){
        if(etEmail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty() || etName.getText().toString().isEmpty() ||
                etAge.getText().toString().isEmpty() || etBp.getText().toString().isEmpty() || etWeight.getText().toString().isEmpty()
                || etContact.getText().toString().isEmpty() || etAddress.getText().toString().isEmpty())
            return true;
        else
            return false;
    }

    public void register(View view) {
        if(isEmpty()){
            Toast.makeText(this, "Please fill all the boxes...!!!!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()){
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.PHONE.matcher(etContact.getText().toString()).matches()){
            Toast.makeText(this, "Please enter a valid contact", Toast.LENGTH_SHORT).show();
            return;
        }
        String gender=rgGender.getCheckedRadioButtonId()==R.id.rbMale?"Male":"Female";
        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);
        Call<ServerResponse> call=apiInterface.registration(etEmail.getText().toString(),etPassword.getText().toString(),
                etName.getText().toString(),gender,etAge.getText().toString(),etBp.getText().toString(),
                etWeight.getText().toString(),etContact.getText().toString(),etAddress.getText().toString());
        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse serverResponse=response.body();
                String message=serverResponse.getResponse();
                if(message.equals("exist")){
                    Toast.makeText(RegisterActivity.this, "This userEntity is already exist", Toast.LENGTH_SHORT).show();
                }
                else if(message.equals("inserted")){
                    Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if(message.equals("not inserted")){
                    Toast.makeText(RegisterActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
