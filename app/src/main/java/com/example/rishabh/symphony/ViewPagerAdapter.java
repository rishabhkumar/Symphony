package com.example.rishabh.symphony;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by rishabh on 11/04/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    _Fragment4_ fragment4_;
    _Fragment3_ fragment3_;

    public ViewPagerAdapter(FragmentManager fm, _Fragment4_ fragment4_, _Fragment3_ fragment3_) {
        super(fm);
        this.fragment4_ = fragment4_;
        this.fragment3_ = fragment3_;
        //super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return fragment4_;
            case 1: return fragment3_;
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0: return "Floating Now";
            case 1: return "Songs List";
        }

        return null;
    }
}
