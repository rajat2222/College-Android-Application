package com.example.college.studentgridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.college.R;
import com.example.college.Student.Demo;
import com.example.college.Student.Imageshow;

public class Busnroutes extends AppCompatActivity {
Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busnroutes);
        button1=findViewById(R.id.btn1);
        button2=findViewById(R.id.btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Busnroutes.this, Demo.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Busnroutes.this, Demo.class));

            }
        });
    }
}
