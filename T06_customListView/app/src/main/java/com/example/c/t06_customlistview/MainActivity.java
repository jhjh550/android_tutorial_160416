package com.example.c.t06_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class MyData{
        String title;
        String desc;
        int imgIcon;

        public MyData(String title, String desc, int imgIcon) {
            this.title = title;
            this.desc = desc;
            this.imgIcon = imgIcon;
        }
    }

    ArrayList<MyData> list = new ArrayList<MyData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int icon = 0;
        for(int i=0; i<30; i++){
            switch (i%4) {
                case 0:
                    icon = android.R.drawable.ic_btn_speak_now;
                    break;
                case 1:
                    icon = android.R.drawable.ic_delete;
                    break;
                case 2:
                    icon = android.R.drawable.ic_media_next;
                    break;
                case 3:
                    icon = android.R.drawable.ic_media_ff;
                    break;
            }

            MyData data = new MyData("data"+i, "desc"+i, icon);
            list.add(data);
        }

        ListView listView = (ListView)findViewById(R.id.listView);


    }
}
