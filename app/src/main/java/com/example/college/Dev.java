package com.example.college;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;

public class Dev extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);
        button=(Button)findViewById(R.id.devlopersimage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com/rohit.r.sharma2"));
                startActivity(intent);
            }
        });

    }
}
