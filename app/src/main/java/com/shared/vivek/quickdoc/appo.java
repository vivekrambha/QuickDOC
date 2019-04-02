package com.shared.vivek.quickdoc;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class appo extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appo);
        t=findViewById(R.id.t2);
        Intent intent=getIntent();
        String s1,s2;
        s1=intent.getStringExtra("filterString");
        s2=intent.getStringExtra("filterString2");

        t.setText(" You have an appointement with "+s2+" who's specialization is "+s1);

    }
}
