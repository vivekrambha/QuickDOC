package com.shared.vivek.quickdoc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.Toast;

public class Doclogin extends AppCompatActivity {

    EditText t1,t2;
    Button bt1,bt2;
    SQLiteDatabase db;
    String gvname;
    String gvpass;
    String t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doclogin);

        t1=findViewById(R.id.name);
        t2=findViewById(R.id.pass);
        bt1=findViewById(R.id.Login);
        bt2=findViewById(R.id.reg);

        db=openOrCreateDatabase("Patient.db",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS PTREGISTER(NAME VARCHAR,ADDRESS VARCHAR,PHONENUMBER INT,PASSWORD INT)");

        //comparing values of t1,t2 & name and password
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=db.rawQuery("SELECT * FROM PTREGISTER",null);
                t3=t1.getText().toString();
                t4=t2.getText().toString();
                int flag = 0;
                while(cursor.moveToNext()){

                    gvname=cursor.getString(0);
                    gvpass=cursor.getString(3);
                    if(!t1.getText().toString().isEmpty()&&!t2.getText().toString().isEmpty())
                    {
                        if(gvname.equals(t3)&& gvpass.equals(t4)){
                            Toast.makeText(Doclogin.this,"Matched",Toast.LENGTH_SHORT).show();
                            flag = 1;
                            break;
                        }
                       else {
                           // Toast.makeText(Doclogin.this, "email or password incorrect", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                       flag=0;
                        Toast.makeText(Doclogin.this,"GIVE ALL VALUES",Toast.LENGTH_SHORT).show();

                        return;
                    }

                }
                //flag for intent
                if(flag==1){
                    Intent i1=new Intent(Doclogin.this,Spin.class);
                    startActivity(i1);
                }
                else{
                    Toast.makeText(Doclogin.this,"GIVE ALL VALUES",Toast.LENGTH_SHORT).show();
                    return;
                }


            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i1=new Intent(Doclogin.this,Patilogin.class);
                    startActivity(i1);
            }
        });

    }
}
