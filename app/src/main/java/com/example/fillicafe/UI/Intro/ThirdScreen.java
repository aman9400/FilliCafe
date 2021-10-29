package com.example.fillicafe.UI.Intro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fillicafe.R;
import com.example.fillicafe.UI.Login.Login;

public class ThirdScreen extends Fragment {
    TextView msg_third,next_third,back_third;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third_screen, container, false);

//        msg_third = view.findViewById(R.id.msg_third);
        next_third = view.findViewById(R.id.next_third);
        back_third = view.findViewById(R.id.back_third);

        viewPager = getActivity().findViewById(R.id.viewPager1);

        next_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(3);
            }
        });

        back_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        return view;
    }
}