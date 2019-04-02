package com.shared.vivek.quickdoc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Patilog extends AppCompatActivity {
    EditText x,y;
    Button bt2,bt1;
    SQLiteDatabase db;
    String ptname,ptpass,t5,t6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patilog);
        x=findViewById(R.id.name);
        y=findViewById(R.id.pass);
        bt2=findViewById(R.id.reg);
        bt1=findViewById(R.id.login);


        db=openOrCreateDatabase("Patient.db",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS PTREGISTER(NAME VARCHAR,ADDRESS VARCHAR,PHONENUMBER INT,PASSWORD INT)");



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!x.getText().toString().isEmpty()&&!y.getText().toString().isEmpty())
                {
                    Cursor cursor=db.rawQuery("SELECT * FROM PTREGISTER",null);
                    t5=x.getText().toString();
                    t6=y.getText().toString();
                    int flag = 0;
                    while(cursor.moveToNext()){

                        ptname=cursor.getString(0);
                        ptpass=cursor.getString(4);
                        if(!x.getText().toString().isEmpty()&&!y.getText().toString().isEmpty())
                        {
                            if(ptname.equals(t5)&& ptpass.equals(t6)){
                                Toast.makeText(Patilog.this,"Matched",Toast.LENGTH_SHORT).show();
                                flag = 1;
                                break;
                            }
                            //     else  Toast.makeText(Doclogin.this,"email or password incorrect",Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(Patilog.this,"GIVE ALL VALUES ",Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }
                   // Toast.makeText(Patilog.this,"OK",Toast.LENGTH_SHORT).show();
                }
                else {
                  //  Toast.makeText(Patilog.this,"GIVE ALL VALUES",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=new Intent(Patilog.this,Doclogin.class);
                startActivity(i1);
            }
        });
    }
}
