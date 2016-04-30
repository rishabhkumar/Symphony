package com.example.rishabh.symphony;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class _Fragment3_ extends Fragment implements AdapterView.OnItemClickListener {


    String string[] = {"Ed Sheeran - Thinking Out Loud", "Alan Walker - Faded", "Ed Sheeran - Nina", "Charlie Puth - One Call Away", "5SOS - Amnesia", "Zayn - PillowTalk", "Fun - We are Young", "Beatles - Baby you're a rich man"};
    Integer image[] = {R.drawable.ed_nina, R.drawable.alan, R.drawable.ed_nina, R.drawable.charlie, R.drawable.amnesia, R.drawable.zmalik, R.drawable.fun1, R.drawable.beatles};
    LayoutInflater inflater1;
    _Fragment1_ fragment1_;

    public _Fragment3_(_Fragment1_ fragment1_) {
        this.fragment1_ = fragment1_;
    }

    public _Fragment3_() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity___fragment3_, container, false);
        inflater1 = LayoutInflater.from(getActivity());
        ListView listView = (ListView) view.findViewById(R.id.listView);
        Class3 class3 = new Class3();
        listView.setAdapter(class3);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        fragment1_.playSong(position);

    }

    public class Class3 extends BaseAdapter
    {


        @Override
        public int getCount() {
            return string.length;
        }

        @Override
        public Object getItem(int position) {
            return string[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater1.inflate(R.layout.custom, parent, false);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            imageView.setImageResource(image[position]);
            TextView textView = (TextView) convertView.findViewById(R.id.textView10);
            textView.setText(string[position]);
            return convertView;
        }
    }

}