package com.example.c.t13_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by c on 2016-04-23.
 */
public class TestSQLiteHandler {
    TestSQLiteOpenHelper helper;
    SQLiteDatabase db;

    public TestSQLiteHandler(Context context) {
        helper = new TestSQLiteOpenHelper(context, "people", null, 1);
    }

    public void insert(String name, int age, String address){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("address", address);
        db.insert("student", null, values);
    }

    public void delete(String name){
        db = helper.getWritableDatabase();
        db.delete("student", "name = ?", new String[]{name});
    }

    public  void update(String name, int newAge){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", newAge);
        db.update("student", values, "name = ?", new String[]{name});
    }
}
