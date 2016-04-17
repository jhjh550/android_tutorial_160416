package com.example.c.p01_listview;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = Environment.getExternalStorageDirectory()+"/Music";
        File dir = new File(path);
        File[] files = dir.listFiles();

        ArrayList<String> list  = new ArrayList<>();
        for(int i=0; i<files.length; i++){
            File f = files[i];
            if(f.isDirectory() == false) {
                String name =f.getName();
                int index = name.lastIndexOf(".wav");
                if(index>0)
                    list.add(f.getName());
            }
        }

        String[] strArrays = list.toArray(new String[list.size()]);

        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, strArrays);
        listView.setAdapter(adapter);

    }
}
