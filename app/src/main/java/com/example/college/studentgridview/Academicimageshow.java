package com.example.college.studentgridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.college.R;
import com.example.college.Student.Demo;

public class Academicimageshow extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academicimageshow);
        AcademicimageAdpater imageAdapter = new AcademicimageAdpater(this);
        Bundle bundle = getIntent().getExtras();
        int pid = bundle.getInt("Index");
        int id = bundle.getInt("Id");
        imageView = (ImageView) findViewById(R.id.imageview2);
        Toast.makeText(getApplicationContext(), "Id" + pid, Toast.LENGTH_LONG).show();
      //  imageView.setImageResource(id);
        switch (pid) {
            case 0: {
                //co curricular activities
                Toast.makeText(getApplicationContext(), "Loading", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Academicimageshow.this, Demo.class);
                startActivity(intent);
                finish();
                break;
            }
            case 1: {
                // rules
                Toast.makeText(getApplicationContext(), "Loading", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Academicimageshow.this, Demo.class);
                startActivity(intent);
                finish();
                break;
            }
            case 2: {
                //result
                Toast.makeText(getApplicationContext(), "Loading", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Academicimageshow.this, Demo.class);
                startActivity(intent);
                finish();
                break;
            }
            case 3: {
                //Assingments
                Toast.makeText(getApplicationContext(), "Loading", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Academicimageshow.this, Demo.class);
                startActivity(intent);
                finish();
                break;
            }
            case 4: {
                // Timetable
                Toast.makeText(getApplicationContext(), "Loading", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Academicimageshow.this, Demo.class);
                startActivity(intent);
                finish();
                break;
            }

            case 5: {
                //Resume
                Toast.makeText(getApplicationContext(), "Loading", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Academicimageshow.this, Demo.class);
                startActivity(intent);
                finish();
                break;
            }
            case 6: {
                //Internalmarks
                Toast.makeText(getApplicationContext(), "Loading", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Academicimageshow.this, Demo.class);
                startActivity(intent);
                finish();
                break;
            }
            case 7: {
                //bus routes
                Toast.makeText(getApplicationContext(), "Loading", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Academicimageshow.this, Demo.class);
                startActivity(intent);
                finish();
                break;
            }


        }
    }
}