package com.example.college.faculty;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.college.Forgetpass;
import com.example.college.R;
import com.example.college.Welcome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Faculty extends AppCompatActivity {
    Button btnlogin, buttonforgetpass;
    EditText eid,ename,epass;
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        myDialog = new Dialog(this);
        eid=(EditText)findViewById(R.id.editid);
        ename=(EditText)findViewById(R.id.editname);
        epass=(EditText)findViewById(R.id.editpass);

        final Teacher teacherLogin=new Teacher(this);

        btnlogin=(Button)findViewById(R.id.btn1);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Intent intent =new Intent(Login.this,Dashboard.class);
                // startActivity(intent);
                // TextView txtclose;
                //Button btnFollow;
                //myDialog.setContentView(R.layout.choose_login);
                //txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
                //txtclose.setText("M");
                //btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
                //txtclose.setOnClickListener(new View.OnClickListener() {
                //  @Override
                //public void onClick(View v) {
                //  myDialog.dismiss();
                //}
                //});
                //myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //myDialog.show();
                String type="Login";
                String id=eid.getText().toString();
                String name=ename.getText().toString();
                String pass=epass.getText().toString();
                try {
                    teacherLogin.execute(type, id, pass);
                    //  Intent intent=new Intent(Login.this,Dashboard.class);
                }
                catch (Exception nm)
                {
                    Toast.makeText(getApplicationContext(),"Please Wait",Toast.LENGTH_LONG).show();
                }//startActivity(intent);


            }
        });
        buttonforgetpass=(Button)findViewById(R.id.btn2);
        buttonforgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Loading Forget Password",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Faculty.this,Forgetpass.class));
            }
        });
    }
    public void ShowPopup(View v) {
    }

}
class Teacher extends AsyncTask<String,Void,String> {
    SharedPreferences sharedPreferences;
    String username="";
    Context context;
    AlertDialog alertDialog;
    Teacher(Context ctx)
    {
        context=ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "https://www.nextsolutions.in/schoolsnext/Demo/Login/teacher_login.php \n" +
                "\n";
        if (type.equals("Login"))
        {
            try {

                username=params[1];
                String userpass=params[2];
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(userpass,"UTF-8");

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

        }
        return null;
    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();

        if(result.equals("login success"))
        {
            sharedPreferences=context.getSharedPreferences("MYPREF",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("Tid",username);
            editor.commit();
            //  Intent intent=new Intent(context,Dashboard.class);
            context.startActivity(new Intent(context, Facultywelcome.class));
        }
        else
        {
            Toast.makeText(context, "Invalid User id or Password", Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

