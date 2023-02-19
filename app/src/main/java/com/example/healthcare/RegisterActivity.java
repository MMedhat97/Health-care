package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    EditText edtReguser,edtRegpass,edtRegemail,edtRegconfirm;
    Button btnRegister;
    TextView tvRegAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtReguser=findViewById(R.id.edtTxtReguser);
        edtRegpass=findViewById(R.id.edtTxtRegpass);
        edtRegemail=findViewById(R.id.edtTxtemail);
        edtRegconfirm=findViewById(R.id.edtTxtconfirmpass);
        btnRegister=findViewById(R.id.buttonReg);
        tvRegAccount=findViewById(R.id.txtViewRegAccount);


        tvRegAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[] {new Intent(RegisterActivity.this,LoginActivity.class)});
            }
        });




    }






}