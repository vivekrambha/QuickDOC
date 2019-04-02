package com.shared.vivek.quickdoc;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Doclog extends AppCompatActivity {


    EditText name;
    EditText qual;
    EditText spaci;
    EditText phone;
    EditText pass;
    Button regi;

    SQLiteDatabase db;
    String Name;
    String Qualification;
    String Spacilization;
    String Phone;
    String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doclog);

        name=findViewById(R.id.name);
        qual=findViewById(R.id.quali);
        spaci=findViewById(R.id.spaci);
        phone=findViewById(R.id.phone);
        regi=findViewById(R.id.reg);
        pass=findViewById(R.id.pass);

        db=openOrCreateDatabase("Doctor.db",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS REGISTER(NAME VARCHAR,QUALIFICATION VARCHAR,SPACIALIZATION VARCHAR,PHONE INT,PASSWORD VARCHAR)");


        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty()||qual.getText().toString().isEmpty()||spaci.getText().toString().isEmpty()||phone.getText().toString().isEmpty()||pass.getText().toString().isEmpty()){
                    Toast.makeText(Doclog.this,"Values not given",LENGTH_SHORT).show();
                    return;
                }
                else {
                    Insert();
                }
            }
        });



    }
    void Insert()
    {
        Name = name.getText().toString();
        Qualification=qual.getText().toString();
        Spacilization=spaci.getText().toString();
        Phone=phone.getText().toString();
        Password=pass.getText().toString();

        db.execSQL("INSERT INTO REGISTER VALUES('"+Name+"','"+Qualification+"','"+Spacilization+"','"+Phone+"','"+Password+"')");
        Toast.makeText(this,"REGISTER SUCCESSFULLY", LENGTH_SHORT).show();
    }
}
