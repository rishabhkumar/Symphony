package com.example.rishabh.symphony;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Placing objects. . .");
        progressDialog.show();
        FragmentManager fragmentManager = getSupportFragmentManager();
        _Fragment4_ fragment4_ = new _Fragment4_(this);
        _Fragment1_ fragment1_ = new _Fragment1_(this, fragment4_);
        _Fragment3_ fragment3_ = new _Fragment3_(fragment1_);
        _Fragment2_ fragment2_ = new _Fragment2_(fragmentManager, fragment4_, fragment3_);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.relativeLayout, fragment1_);
        fragmentTransaction.add(R.id.relativeLayout2, fragment2_);
        fragmentTransaction.commit();
        progressDialog.dismiss();
    }
}
