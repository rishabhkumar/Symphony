package com.example.rishabh.symphony;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class _Fragment2_ extends Fragment{

    FragmentManager fragmentManager;
    _Fragment4_ fragment4_;
    _Fragment3_ fragment3_;

    public _Fragment2_(FragmentManager fragmentManager, _Fragment4_ fragment4_1, _Fragment3_ fragment3_) {
        this.fragmentManager = fragmentManager;
        this.fragment4_ = fragment4_1;
        this.fragment3_ = fragment3_;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity___fragment2_, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragmentManager, fragment4_, fragment3_);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}