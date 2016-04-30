package com.example.c.t25_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){
        NotificationManager manger =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(this, NotiActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pIntent = PendingIntent.getActivity(this,0, intent, 0);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.tulips);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("TITLE");
        builder.setContentText("TEXT");
        builder.setSubText("SUB TEXT");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(bm);
        builder.setContentIntent(pIntent);
        Notification noti = builder.build();

        manger.notify(1234, noti);
    }
}
