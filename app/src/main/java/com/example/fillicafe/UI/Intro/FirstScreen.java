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
import android.widget.Button;
import android.widget.TextView;

import com.example.fillicafe.R;
import com.example.fillicafe.UI.Login.Login;

public class FirstScreen extends Fragment {

    TextView msg_first,next_first;
    ViewPager viewPager;
    Button skip_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_first_screen, container, false);

//        msg_first = view.findViewById(R.id.msg_first);
        next_first = view.findViewById(R.id.next_first);
        skip_btn = view.findViewById(R.id.skip_btn);

        viewPager = getActivity().findViewById(R.id.viewPager1);

        next_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("intro","yes");
                editor.apply();

                startActivity(new Intent(getContext(), Login.class));
                getActivity().finish();
            }
        });

        return view;
    }
}