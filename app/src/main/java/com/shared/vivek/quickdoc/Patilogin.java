package com.shared.vivek.quickdoc;

import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Patilogin extends AppCompatActivity {
    EditText a,b,c,d;
    Button btn;
    SQLiteDatabase db;

    String Name;
    String Add;
    String Phone;
    String Pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patilogin);


        a=findViewById(R.id.name);
        b=findViewById(R.id.add);
        c=findViewById(R.id.phone);
        d=findViewById(R.id.pass);
        btn=findViewById(R.id.Reg);

        db=openOrCreateDatabase("Patient.db",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS PTREGISTER(NAME VARCHAR,ADDRESS VARCHAR,PHONENUMBER INT,PASSWORD INT)");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(a.getText().toString().isEmpty()||b.getText().toString().isEmpty()||c.getText().toString().isEmpty()||d.getText().toString().isEmpty()){
                    Toast.makeText(Patilogin.this,"Values not given",LENGTH_SHORT).show();
                    return;
                }
                else {
                    Insert();
                }

            }
        });



    }
    void Insert(){
        Name = a.getText().toString();
        Add=b.getText().toString();
        Phone=c.getText().toString();
        Pass=d.getText().toString();

        db.execSQL("INSERT INTO PTREGISTER VALUES('"+Name+"','"+ Add+"','"+Phone+"','"+Pass+"')");
        Toast.makeText(this,"REGISTER SUCCESSFULLY",Toast.LENGTH_SHORT).show();

    }
}
