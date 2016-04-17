package com.example.c.t06_customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                LayoutInflater inf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inf.inflate(R.layout.item_view, null);
            }

            TextView textViewTitle = (TextView)convertView.findViewById(R.id.textViewTitle);
            TextView textViewDesc = (TextView)convertView.findViewById(R.id.textViewDesc);
            ImageView item_icon = (ImageView)convertView.findViewById(R.id.item_icon);

            MyData data = list.get(position);
            textViewTitle.setText(data.title);
            textViewDesc.setText(data.desc);
            item_icon.setImageResource(data.imgIcon);

            return convertView;
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
