package com.example.college.faculty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.college.R;
import com.example.college.Student.Demo;
import com.example.college.facgridview.Upattend;
import com.example.college.facgridview.Upexam;
import com.example.college.facgridview.Facproifile;
import com.example.college.facgridview.Notice;

public class Facimageshow extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facimageshow);
        imageView=(ImageView)findViewById(R.id.imgview);
        Bundle bundle=getIntent().getExtras();
        int pid=bundle.getInt("Index");
        int id=bundle.getInt("Id");
        imageView=(ImageView)findViewById(R.id.imgview);
    //    Toast.makeText(getApplicationContext(),"Id" +pid, Toast.LENGTH_LONG).show();
      //  imageView.setImageResource(pid);
       switch(pid)
        {
            case 0:
            {
                //profile
                Toast.makeText(getApplicationContext(),"Loading Profile" ,Toast.LENGTH_LONG).show();
                startActivity(new Intent(Facimageshow.this, Facproifile.class));
                finish();
                break;
            }
            case 1:
            {
                //Notice
                Toast.makeText(getApplicationContext(),"Loading Notice" ,Toast.LENGTH_LONG).show();
               startActivity(new Intent(Facimageshow.this, Demo.class));
                finish();
                break;
            }
            case 2:
            {
                //Attendance
            Toast.makeText(getApplicationContext(),"Loading Attendance" ,Toast.LENGTH_LONG).show();
           startActivity(new Intent(Facimageshow.this, Demo.class));
            finish();
            break;
            }
        case 3:
        {
            //Exams
            Toast.makeText(getApplicationContext(),"Loading Exams" ,Toast.LENGTH_LONG).show();
            startActivity(new Intent(Facimageshow.this, Demo.class));
            finish();
            break;
        }
        case 4:
        {
            //Schedular
            Toast.makeText(getApplicationContext(),"Loading Schedular" ,Toast.LENGTH_LONG).show();
            startActivity(new Intent(Facimageshow.this, Demo.class));
            finish();
            break;
        }
        case 5:
        {
            //Notes
            Toast.makeText(getApplicationContext(),"Loading Notes" ,Toast.LENGTH_LONG).show();
            startActivity(new Intent(Facimageshow.this, Demo.class));
            finish();
            break;
        }
            default :
            {
                Toast.makeText(getApplicationContext(),"Please Select Something",Toast.LENGTH_LONG).show();
            break;
            }
        }

    }
}
