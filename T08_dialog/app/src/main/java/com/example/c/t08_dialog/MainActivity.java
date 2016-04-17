package com.example.c.t08_dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int myId = 0;
    public void onShowDialog(View v){
        showDialog(myId);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == myId){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("TITLE");
            builder.setMessage("MESSAGE");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "OK Button", Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //
                }
            });
            return builder.create();
        }
        return  null;
    }
}
