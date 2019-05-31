package com.example.college.studentgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.college.R;

public class Course extends AppCompatActivity {
    EditText editText;
    Button button;
    Spinner spinner1,spinner2;
    String chose="";
    String choose="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }
}
