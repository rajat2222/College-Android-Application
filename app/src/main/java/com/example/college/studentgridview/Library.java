package com.example.college.studentgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.college.R;

public class Library extends AppCompatActivity {
    EditText editText;
    Button button;
    Spinner spinner1;
    String chose="";

    String books[]={"Book Issued in :","First year" ,"Second Year","Third year","Fourth Year" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        spinner1 = (Spinner) findViewById(R.id.spn1);
        editText = (EditText) findViewById(R.id.txt1);
        button = (Button) findViewById(R.id.btn);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, books);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chose = books[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
