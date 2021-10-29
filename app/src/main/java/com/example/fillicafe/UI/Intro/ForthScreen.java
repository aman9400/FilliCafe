package com.example.fillicafe.UI.Intro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.fillicafe.R;
import com.example.fillicafe.UI.Login.Login;

public class ForthScreen extends Fragment {

    TextView msg_third,next_forth,back_forth;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forth_screen, container, false);

//        msg_third = view.findViewById(R.id.msg_third);
        next_forth = view.findViewById(R.id.next_forth);
        back_forth = view.findViewById(R.id.back_forth);

        viewPager = getActivity().findViewById(R.id.viewPager1);

        next_forth.setOnClickListener(new View.OnClickListener() {
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

        back_forth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });

        return view;
    }
}