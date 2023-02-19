package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtxtuser,edtxtpassword;
    Button btnlogin;
    TextView tvLogAccount;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtxtuser=findViewById(R.id.edtTxtuser);
        edtxtpassword=findViewById(R.id.edtTxtpass);
        btnlogin=findViewById(R.id.buttonlgn);
        tvLogAccount=findViewById(R.id.txtViewLogAccount);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edtxtuser.getText().toString();
                String password=edtxtpassword.getText().toString();
                if (username.length()==0 || password.length()==0){
                    Toast.makeText(LoginActivity.this, "Please Insert All Details", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvLogAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(LoginActivity.this, RegisterActivity.class)});
            }
        });



    }
}