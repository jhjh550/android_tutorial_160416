package com.example.c.t24_fragment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fr = fm.findFragmentById(R.id.frame);
        switch (v.getId()){
            case R.id.btnAdd:
                if(fr == null){
                    fr = new BlankFragment();
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.add(R.id.frame, fr, "counter");
                    tr.commit();
                }
                break;
            case R.id.btnRemove:
                if(fr != null){
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.remove(fr);
                    tr.commit();
                }
                break;
            case R.id.btnReplace:
                if(fr != null){

                }
                break;
            case R.id.btnHide:
                if(fr != null){
                    FragmentTransaction tr = fm.beginTransaction();
                    if(fr.isHidden())
                        tr.show(fr);
                    else
                        tr.hide(fr);

                    tr.commit();
                }
                break;
        }
    }
}
