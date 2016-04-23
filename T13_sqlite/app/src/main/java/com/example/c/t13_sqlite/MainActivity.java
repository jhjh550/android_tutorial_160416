package com.example.c.t13_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView);
        TestSQLiteHandler dbHandler = new TestSQLiteHandler(this);
        dbHandler.insert("kim", 20, "서울");
        dbHandler.insert("lee", 30, "인천");

        dbHandler.update("kim", 22);

        String res = dbHandler.selectAll();
        textView.setText(res);


    }
}
