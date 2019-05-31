package com.example.college;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.college.Student.Studentwelcome;

public class Rateus extends AppCompatActivity {
    Button btn;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rateus);
        ratingBar=(RatingBar)findViewById(R.id.rate);
        btn=(Button)findViewById(R.id.btnsubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), "thankyou for rating : "+value, Toast.LENGTH_LONG).show();
                startActivity(new Intent(Rateus.this, Studentwelcome.class));
            }
        });
    }
}

