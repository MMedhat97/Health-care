package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1=
            {
                    {"Doctor Name : Mohamed AbdElfatah","Hospital Name : Ain Shams","Exp : 5yrs","Mobile No : 01234567890","600"},
                    {"Doctor Name : Ali Youssef ","Hospital Name : Ain Shams","Exp : 7yrs","Mobile No : 01234567890","200"},
                    {"Doctor Name : Mohamed ElShazly","Hospital Name : Elkahara","Exp : 10yrs","Mobile No : 01234567890","300"},
                    {"Doctor Name : Mohamed Salah","Hospital Name : Ain Shams","Exp : 9yrs","Mobile No : 01234567890","500"},
                    {"Doctor Name : Ibrahim Taha","Hospital Name : ElKasrElAiny","Exp : 6yrs","Mobile No : 01234567890","600"},
                    {"Doctor Name : Ahmed Ebrahim","Hospital Name : Ain Shams","Exp : 15yrs","Mobile No : 01234567890","400"}
            };

    private String[][] doctor_details2=
            {
                    {"Doctor Name : AbdElmonym","Hospital Name : Ain Shams","Exp : 11yrs","Mobile No : 01234567890","600"},
                    {"Doctor Name : Salah Khalil ","Hospital Name : Ain Shams","Exp : 4yrs","Mobile No : 01234567890","900"},
                    {"Doctor Name : Mayada Mohamed","Hospital Name : Elkahara","Exp : 17yrs","Mobile No : 01234567890","1000"},
                    {"Doctor Name : Sally Rafat","Hospital Name : Ain Shams","Exp : 18yrs","Mobile No : 01234567890","800"},
                    {"Doctor Name : Mohamed Morsy","Hospital Name : ElKasrElAiny","Exp : 20yrs","Mobile No : 01234567890","700"},
                    {"Doctor Name : Ahmed Nashat","Hospital Name : Ain Shams","Exp : 13yrs","Mobile No : 01234567890","1100"}
            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name : Salah Medhat","Hospital Name : Ain Shams","Exp : 19yrs","Mobile No : 01234567890","1200"},
                    {"Doctor Name : Mohamed Foad ","Hospital Name : Ain Shams","Exp : 17yrs","Mobile No : 01234567890","1300"},
                    {"Doctor Name : Mahmoud AbdElazia","Hospital Name : Elkahara","Exp : 30yrs","Mobile No : 01234567890","1800"},
                    {"Doctor Name : Essra Elhussieny","Hospital Name : Ain Shams","Exp : 13yrs","Mobile No : 01234567890","800"},
                    {"Doctor Name : Asmaa Ibrahim","Hospital Name : ElKasrElAiny","Exp : 26yrs","Mobile No : 01234567890","900"},
                    {"Doctor Name : Aya Salah","Hospital Name : Ain Shams","Exp : 20yrs","Mobile No : 01234567890","550"}
            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name : Hakeem Ahmed","Hospital Name : Ain Shams","Exp : 6yrs","Mobile No : 01234567890","750"},
                    {"Doctor Name : Ashraf Badr ","Hospital Name : Ain Shams","Exp : 7yrs","Mobile No : 01234567890","960"},
                    {"Doctor Name : Reda Shoubra","Hospital Name : Elkahara","Exp : 9yrs","Mobile No : 01234567890","1500"},
                    {"Doctor Name : Nada Salah","Hospital Name : Ain Shams","Exp : 16yrs","Mobile No : 01234567890","2000"},
                    {"Doctor Name : Adel Aziz","Hospital Name : ElKasrElAiny","Exp : 17yrs","Mobile No : 01234567890","1850"},
                    {"Doctor Name : Hesham farouk","Hospital Name : Ain Shams","Exp : 13yrs","Mobile No : 01234567890","1700"}
            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name : Mohamed Medhat","Hospital Name : Ain Shams","Exp : 25yrs","Mobile No : 01234567890","950"},
                    {"Doctor Name : Ahmed Youssef ","Hospital Name : Ain Shams","Exp : 15yrs","Mobile No : 01234567890","550"},
                    {"Doctor Name : Salah Elbahrawy","Hospital Name : Elkahara","Exp : 30yrs","Mobile No : 01234567890","450"},
                    {"Doctor Name : Yasser Mohamed","Hospital Name : Ain Shams","Exp : 18yrs","Mobile No : 01234567890","650"},
                    {"Doctor Name : Sahar Basos","Hospital Name : ElKasrElAiny","Exp : 17yrs","Mobile No : 01234567890","350"},
                    {"Doctor Name : Mostafa Shabana","Hospital Name : Ain Shams","Exp : 22yrs","Mobile No : 01234567890","850"}
            };


    TextView textView;
    Button button;
    String [][] doctor_details= {};
    ArrayList arrayList;
    SimpleAdapter simpleAdapter;

    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        textView = findViewById(R.id.textdefaultView);
        button = findViewById(R.id.btndocdback);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        textView.setText(title);
        if (title.compareTo("Family Physician")==0)
            doctor_details=doctor_details1;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details=doctor_details2;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details=doctor_details3;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });


        arrayList = new ArrayList();
        for (int i=0; i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees : "+doctor_details[i][4] + "/-");
            arrayList.add(item);
        }

        simpleAdapter = new SimpleAdapter(this,arrayList,
                R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});


        ListView listView =findViewById(R.id.listviewdocd);
        listView.setAdapter(simpleAdapter);





    }
}