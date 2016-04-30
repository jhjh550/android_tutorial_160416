package com.example.c.t23_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class BlankFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        final TextView textViewCounter = (TextView) view.findViewById(R.id.textViewCounter);
        Button btnIncrease = (Button)view.findViewById(R.id.btnIncrease);
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = textViewCounter.getText().toString();
                int value = Integer.parseInt(str);
                value++;
                textViewCounter.setText(""+value);
            }
        });
        return view;
    }

}
