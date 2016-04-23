package com.example.c.t13_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestSQLiteOpenHelper helper = new TestSQLiteOpenHelper(this, "people", null, 1);
    }
}
