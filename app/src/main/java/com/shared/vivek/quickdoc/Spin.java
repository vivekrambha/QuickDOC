package com.shared.vivek.quickdoc;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Spin extends Doclogin implements AdapterView.OnClickListener,AdapterView.OnItemSelectedListener{
    Spinner s1,s2;
    List spacial,fill;
    Button bt;
    String filterString="";
    String filterString2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);
        s1=findViewById(R.id.sp1);
        s2=findViewById(R.id.sp2);
        bt=findViewById(R.id.btn);

        spacial=new ArrayList();
        spacial.add("Choose Any One");
        spacial.add("cardiologists ");
        spacial.add("dermatologists ");
        spacial.add("gastroenterologists");
        spacial.add("neurologists");
        spacial.add("radiologists ");

        db=openOrCreateDatabase("Doctor.db",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS REGISTER(NAME VARCHAR,QUALIFICATION VARCHAR,SPACIALIZATION VARCHAR,PHONE INT,PASSWORD VARCHAR)");

        ArrayAdapter sp=new ArrayAdapter(Spin.this,android.R.layout.simple_list_item_1,spacial);
        s1.setAdapter(sp);
        s1.setOnItemSelectedListener(this);

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filterString2 = s2.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    bt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i3=new Intent(Spin.this,appo.class);
            i3.putExtra("filterString",filterString);
            i3.putExtra("filterString2",filterString2);
            startActivity(i3);

        }
    });
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            if(!s1.getItemAtPosition(position).toString().equals("Choose Any One")){
                filterString =s1.getItemAtPosition(position).toString();
            }
            filter();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void filter(){
        if(filterString!=null && !filterString.equals("")){

            Cursor cursor = db.rawQuery("Select * from REGISTER where SPACIALIZATION = '"+filterString+"' ",null);
          //  Toast.makeText(Spin.this,"inside filter",Toast.LENGTH_SHORT).show();
            ArrayList<String> arrayList = new ArrayList<>();
            while(cursor.moveToNext()){
                String doctorname = cursor.getString(0);
                arrayList.add(doctorname);
            }

            ArrayAdapter sp2=new ArrayAdapter(Spin.this,android.R.layout.simple_list_item_1,arrayList);
            s2.setAdapter(sp2);
        }
    }
}
