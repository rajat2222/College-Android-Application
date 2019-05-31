package com.example.college;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.college.Student.Student;
import com.example.college.faculty.Faculty;

public class Welcome extends AppCompatActivity {
RadioButton radioButton1,radioButton;
Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
         radioButton = (RadioButton) findViewById(R.id.rgb1);
         radioButton1 = (RadioButton) findViewById(R.id.rgb2);
        btn1=(Button)findViewById(R.id.btnn);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)

         {
             if (radioButton.isChecked())
             {
                 Toast.makeText(getApplicationContext(), "Loading Faculty Dashboard", Toast.LENGTH_SHORT).show();
                 Intent i =new Intent(Welcome.this, Faculty.class);
                 startActivity(i);
             }
             else if (radioButton1.isChecked())

             {
                 Toast.makeText(getApplicationContext(), "Loading Student Dashboard", Toast.LENGTH_SHORT).show();
                 Intent i = new Intent(Welcome.this, Student.class);
                 startActivity(i);
             }
             else{
                 Toast.makeText(getApplicationContext(), "Select from above", Toast.LENGTH_SHORT).show();
             }

         }
        });

    }
}
