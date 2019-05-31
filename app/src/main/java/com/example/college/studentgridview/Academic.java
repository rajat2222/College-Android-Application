package com.example.college.studentgridview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.college.R;

public class Academic extends AppCompatActivity {
    GridView gridView;
    Context context;
    AcademicimageAdpater imageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);

        context=getApplicationContext();
        imageAdapter=new  AcademicimageAdpater(context);
        gridView=(GridView)findViewById(R.id.Gridview2);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Academic.this, Academicimageshow.class);
                intent.putExtra("Id",imageAdapter.imageid[position]);
                intent.putExtra("Index",position);
                startActivity(intent);
            }
        });
    }
}
