package com.example.c.t26_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int TAKE_PHOTO = 1;
    public void onBtnClick(View v){
        String dirPath = Environment.getExternalStorageDirectory()+"/TTT";
        File dir = new File(dirPath);
        if(!dir.exists())
            dir.mkdirs();

        String path = dirPath+"/26.jpg";

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path)));

        startActivityForResult(intent, TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == TAKE_PHOTO){
            if(resultCode == RESULT_OK){
                String dirPath = Environment.getExternalStorageDirectory()+"/TTT";
                String path = dirPath+"/26.jpg";

                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Bitmap bm;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4;

                bm = BitmapFactory.decodeFile(path, options);
                imageView.setImageBitmap(bm);
            }
        }
    }
}
