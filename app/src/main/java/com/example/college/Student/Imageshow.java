package com.example.college.Student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.college.R;
import com.example.college.studentgridview.Academic;
import com.example.college.studentgridview.Attendance;
import com.example.college.studentgridview.Busnroutes;
import com.example.college.studentgridview.Course;
import com.example.college.studentgridview.Fees;
import com.example.college.studentgridview.Library;
import com.example.college.studentgridview.Myprofile;

public class Imageshow extends AppCompatActivity
{
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageshow);
        ImageAdapter imageAdapter=new ImageAdapter(this);
        Bundle bundle=getIntent().getExtras();
        int pid=bundle.getInt("Index");
        int id=bundle.getInt("Id");
        imageView=(ImageView)findViewById(R.id.imageview1);
        //Toast.makeText(getApplicationContext(),"Id" +pid, Toast.LENGTH_LONG).show();
        //imageView.setImageResource(id);
        switch (pid)
        {
            case 0 :
            {
                //my profile
              //  Toast.makeText(getApplicationContext(),"O is Calling",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Imageshow.this, Myprofile.class);
                startActivity(intent);
                finish();
                break;
            }
           case 1 :
            {
                // Attendence
                Toast.makeText(getApplicationContext(),"Loading Attendance Panel",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Imageshow.this, Attendance.class);
                startActivity(intent);
                finish();
                break;

                }
           case 2 :
            {
                //course
                Toast.makeText(getApplicationContext(),"Loading Course",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Imageshow.this, Course.class);
                startActivity(intent);
                finish();
                break;
            }
            case 3 :
            {
                // Library
                Toast.makeText(getApplicationContext(),"Loading Library",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Imageshow.this, Library.class);
                startActivity(intent);
                finish();
                break;
                }
            case 4 :
            {
                // list of holidays
                Toast.makeText(getApplicationContext(),"Loading Holiday List",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Imageshow.this,Demo.class);
                startActivity(intent);
                finish();
            }
            case 5 :
            {
                // Fees and more
                Intent intent=new Intent(Imageshow.this,Fees.class);
                startActivity(intent);
                finish();
                break;
            }
            case 6 :
            {
                // Academic
                 Intent intent=new Intent(Imageshow.this, Academic.class);
                startActivity(intent);
                finish();
                break;
            }
            case 7 :
            {
                // bus and stops
               startActivity(new Intent(Imageshow.this,Busnroutes.class));
               finish();
               break;
            }
            case 8 :
            {
                //Enrichments
                Intent intent=new Intent(Imageshow.this,Demo.class);
                startActivity(intent);
                finish();
                break;
            }
            case 9 :
            {
                // Non Academic
                Intent intent=new Intent(Imageshow.this,Demo.class);
                startActivity(intent);
                finish();
                break;
            }
            case 10 :
            {

                //upcoming events
                Intent intent=new Intent(Imageshow.this,Demo.class);
                startActivity(intent);
                finish();
                break;
            }
            case 11 :
            {
                //Nature club
                Intent intent=new Intent(Imageshow.this,Demo.class);
                startActivity(intent);
                finish();
                break;
            }

//       default:
  //          Toast.makeText(getApplicationContext(),"Wrong Selection",Toast.LENGTH_LONG).show();

        }
    }
}
