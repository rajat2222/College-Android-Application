package com.example.college;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
int time = 3000;
TextView textView;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.header);
        textView.postDelayed(new Runnable() {
            @Override
            public void run() {
            Intent i=new Intent(MainActivity.this,Appintro.class);
            startActivity(i);
            }
        },time);
        b=(Button)findViewById(R.id.btnn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Appintro.class));
            }
        });
    }
}
