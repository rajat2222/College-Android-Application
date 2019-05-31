package com.example.college.studentgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.college.R;

public class Fees extends AppCompatActivity {
Button button,button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);
        button=(Button)findViewById(R.id.btn1);
        button1=(Button)findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Loading Fees Portal",Toast.LENGTH_LONG).show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Loading your recipts",Toast.LENGTH_LONG).show();
            }
        });
    }
}
