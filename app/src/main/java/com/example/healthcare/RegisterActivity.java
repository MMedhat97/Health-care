package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edtReguser.getText().toString();
                String password=edtRegpass.getText().toString();
                String email=edtRegemail.getText().toString();
                String confirmemail=edtRegconfirm.getText().toString();
                Database database =new Database(getApplicationContext(),"healthy",null,1);

                if (username.length()==0 || email.length()==0 || password.length()==0 || confirmemail.length()==0){
                    Toast.makeText(RegisterActivity.this, "Please Insert All Details", Toast.LENGTH_SHORT).show();
                }else {
                    if (password.compareTo(confirmemail)==0){
                        if (isValid(password)){
                            database.register(username,email,password);
                            Toast.makeText(RegisterActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }else {
                            Toast.makeText(RegisterActivity.this, "password must contain at least 8 character ,having letter ,digit and special symbols", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(RegisterActivity.this, "password and confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });



    }

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;

        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
        }
        for (int r = 0; r < passwordhere.length(); r++) {
            if (Character.isDigit(passwordhere.charAt(r))) {
                f2 = 1;
            }
        }
        for (int s = 0; s < passwordhere.length(); s++) {
            char c = passwordhere.charAt(s);
            if (c >= 33 && c <= 46 || c == 64) {
                f3 = 1;
            }
        }

        if (f1 == 1 && f2 == 1 && f3 == 1) {
            return true;

        }

        return false;
    }
    }