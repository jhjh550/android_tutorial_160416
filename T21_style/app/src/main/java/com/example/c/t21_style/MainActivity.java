package com.example.c.t21_style;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView selectedText, workingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedText = (TextView)findViewById(R.id.selectedTextView);
        workingTextView = (TextView)findViewById(R.id.workingTextView);

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                String value = btn.getText().toString();
                String working = workingTextView.getText().toString();
                if(working.equals("0")){
                    workingTextView.setText(value);
                }else{
                    workingTextView.setText(working+value);
                }
            }
        };
        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);
        Button oneBtn = (Button)findViewById(R.id.oneBtn);
        zeroBtn.setOnClickListener(numberListener);
        oneBtn.setOnClickListener(numberListener);
        Button enterBtn = (Button)findViewById(R.id.enterBtn);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String working = workingTextView.getText().toString();
                if(working.length()>0)
                    selectedText.setText(working);
                workingTextView.setText("0");
            }
        });

    }
}
