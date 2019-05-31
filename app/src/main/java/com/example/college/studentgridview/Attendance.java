package com.example.college.studentgridview;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.college.R;

public class Attendance extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;
    Context context;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        context=getApplicationContext();
        webView=(WebView)findViewById(R.id.webview1);
        progressBar=(ProgressBar)findViewById(R.id.Progressbar1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setDatabaseEnabled(true);
        sharedPreferences=context.getSharedPreferences("MYPREF",MODE_PRIVATE);
        String tid=sharedPreferences.getString("Tid",null);
        webView.loadUrl("http://www.nextsolutions.in/schoolsnext.in/Demo/Attendance.php?Tid="+tid);
        webView.setWebViewClient(new MyWebClient());
    }

    private class MyWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}
