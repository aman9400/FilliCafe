package com.example.fillicafe.UI.Intro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fillicafe.R;

public class SecondScreen extends Fragment {

    TextView msg_second,next_second,back_second;
    ViewPager viewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_second_screen, container, false);

//        msg_second = view.findViewById(R.id.msg_second);
        next_second = view.findViewById(R.id.next_second);
        back_second = view.findViewById(R.id.back_second);

        viewPager = getActivity().findViewById(R.id.viewPager1);

        next_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });

        back_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });


        return view;
    }
}