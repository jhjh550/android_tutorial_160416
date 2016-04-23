package com.example.c.t15_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String str = "[{'name':'kim','tel':'010-1111-2222','age':20}," +
            "{'name':'park','tel':'010-2222-3333','age':30}," +
            "{'name':'lee','tel':'010-3333-4444', 'age':40}]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONArray array = new JSONArray(str);
            for(int i=0; i<array.length(); i++){
                JSONObject obj = array.getJSONObject(i);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
