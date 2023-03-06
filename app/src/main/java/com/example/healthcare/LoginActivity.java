package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
                Database database =new Database(getApplicationContext(),"healthy",null,1);
                if (username.length()==0 || password.length()==0){
                    Toast.makeText(LoginActivity.this, "Please Insert All Details", Toast.LENGTH_SHORT).show();
                }else {
                    if (database.login(username,password)==1) {
                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences =getSharedPreferences("shared", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();

                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }else {
                        Toast.makeText(LoginActivity.this, "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvLogAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });



    }
}