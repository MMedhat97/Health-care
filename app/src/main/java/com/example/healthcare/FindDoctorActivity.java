package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit=findViewById(R.id.backfindoctor);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(FindDoctorActivity.this,HomeActivity.class)});
            }
        });


        CardView familyphysician=findViewById(R.id.familyphysicians);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Family Physician");
                startActivity(it);
                //startActivities(new Intent[]{new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class)});
            }
        });


        CardView dentist=findViewById(R.id.dentist);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
                //startActivities(new Intent[]{new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class)});
            }
        });

        CardView Surgeon=findViewById(R.id.surgeon);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
                //startActivities(new Intent[]{new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class)});
            }
        });



        CardView dietician=findViewById(R.id.dietician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
                //startActivities(new Intent[]{new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class)});
            }
        });

        CardView cardiologists=findViewById(R.id.cardiologists);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","CardioLogists");
                startActivity(it);
                //startActivities(new Intent[]{new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class)});
            }
        });

























        
    }
}