package com.example.college;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.college.Student.Studentwelcome;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Communication extends AppCompatActivity {
    EditText editText1,editText2;
    Spinner spinner,spinner1,spinner2;
    String chose="";
    String choose="";
    String dpt="";
    String year[]={"Choose Year :","First Year","Second Year","Third Year","Fourth Year" };
    String semester[]={"Choose Semester :","1 Semester","2 Semester","3 Semester","4 Semester","5 Semester","6 Semester","7 Semester","8 Semester"};
    String dept[]={"Choose Department :","CSE","EC","ME","CE","IT","EE"};

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        final Communicate_Regis communicate_regis=new Communicate_Regis(this);

        editText1=(EditText)findViewById(R.id.txtenroll);
        editText2=(EditText)findViewById(R.id.txtmgs);
        spinner=(Spinner)findViewById(R.id.spnnr);
        spinner1=(Spinner)findViewById(R.id.spnnr1);
        spinner2=(Spinner)findViewById(R.id.spnnr2);
        button=(Button)findViewById(R.id.btn4);

    /*    context=getApplicationContext();
        sharedPreferences=context.getSharedPreferences("MYPREF",MODE_PRIVATE);
        String tid=sharedPreferences.getString("Tid",null);
        editText1.setText(tid);
    */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Saving data", Toast.LENGTH_SHORT).show();
                String type="Login";
                String id=editText1.getText().toString();
                String message=editText2.getText().toString();

                try {
                    communicate_regis.execute(id,chose, choose, dpt,message);
                    //  Intent intent=new Intent(Login.this,Dashboard.class);
                }
                catch (Exception nm)
                {
                    Toast.makeText(getApplicationContext(),"Please try after 5 minutes",Toast.LENGTH_LONG).show();
                }
              //  startActivity(new Intent(Communication.this,.class));

                finish();

            }

        });



        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, year);
        ArrayAdapter<String> semarrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, semester);
        ArrayAdapter<String> deptarrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, dept);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chose = year[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner1.setAdapter(semarrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                choose= semester[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setAdapter(deptarrayAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dpt=dept[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

class Communicate_Regis extends AsyncTask<String,Void,String> {
    SharedPreferences sharedPreferences;
    String username="";
    Context context;
    AlertDialog alertDialog;
    Communicate_Regis(Context ctx)
    {
        context=ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String login_url = "https://www.nextsolutions.in/schoolsnext/Demo/Login/com.php";

            try {

                String id=params[0];
                String year=params[1];
                String sem=params[2];
                String dept=params[3];
                String message=params[4];

                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("sroll","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"+URLEncoder.encode("year","UTF-8")+"="+URLEncoder.encode(year,"UTF-8")+"&"+URLEncoder.encode("sem","UTF-8")+"="+URLEncoder.encode(sem,"UTF-8")+"&"+URLEncoder.encode("dep","UTF-8")+"="+URLEncoder.encode(dept,"UTF-8")+"&"+URLEncoder.encode("msg","UTF-8")+"="+URLEncoder.encode(message,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }


        return null;

    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Message sent");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();

        if(result.equals("Message Send"))
        //{
            Toast.makeText(context,"Sent successfully",Toast.LENGTH_LONG).show();
            //sharedPreferences=context.getSharedPreferences("MYPREF",Context.MODE_PRIVATE);
            //SharedPreferences.Editor editor=sharedPreferences.edit();
            //editor.putString("Tid",username);
            //editor.commit();
            //  Intent intent=new Intent(context,Dashboard.class);
            context.startActivity(new Intent(context, Studentwelcome.class));

        //}


    }



    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

