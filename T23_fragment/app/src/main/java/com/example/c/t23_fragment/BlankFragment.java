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
        TextView textViewCounter = (TextView) view.findViewById(R.id.textViewCounter);
        Button btnIncrease = (Button)view.findViewById(R.id.btnIncrease);
        return view;
    }

}
