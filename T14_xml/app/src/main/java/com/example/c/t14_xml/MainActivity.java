package com.example.c.t14_xml;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Document;

public class MainActivity extends AppCompatActivity {

    class MyDomParser extends AsyncTask<String, Void, Document>{

        @Override
        protected Document doInBackground(String... params) {
            return null;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
