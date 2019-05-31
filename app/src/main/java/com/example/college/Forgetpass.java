package com.example.college;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.college.Student.Demo;

public class Forgetpass extends AppCompatActivity {
EditText editText;
Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);
        editText=(EditText)findViewById(R.id.edx);
        btn=(Button)findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"loading",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Forgetpass.this, Demo.class));
            }
        });
        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"loading",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Forgetpass.this,Welcome.class));

            }
        });

    }
}
