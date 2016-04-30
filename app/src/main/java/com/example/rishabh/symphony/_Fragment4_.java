package com.example.rishabh.symphony;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

@SuppressLint("ValidFragment")
public class _Fragment4_ extends Fragment{

    TextView textView, textView1;
    MainActivity mainActivity;
    String url = "http://www.metrolyrics.com/";
    //String string[] = {"Ed Sheeran - Thinking Out Loud", "Alan Walker - Faded", "Ed Sheeran - Nina", "Charlie Puth - One Call Away", "5SOS - Amnesia", "Zayn - PillowTalk", "Fun - We are Young", "Beatles - Baby you're a rich man"};
    //String data;
    String string[] = {"Ed Sheeran - Thinking Out Loud", "Alan Walker - Faded", "Ed Sheeran - Nina", "Charlie Puth - One Call Away", "5SOS - Amnesia", "Zayn - PillowTalk", "Fun - We are Young", "Beatles - Baby you're a rich man"};
    int position;
    Integer image[] = {R.drawable.ed_nina, R.drawable.alan, R.drawable.ed_nina, R.drawable.charlie, R.drawable.amnesia, R.drawable.zmalik, R.drawable.fun1, R.drawable.beatles};

    public _Fragment4_(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity___fragment4_, container, false);
        textView = (TextView) view.findViewById(R.id.textView2a);
        textView1 = (TextView) view.findViewById(R.id.textViewa);
        return view;
    }

    public void showLyrics(int pos)
    {
        url = "http://www.metrolyrics.com/";
        if (pos == 0) {
            url += "thinking-out-loud-lyrics-ed-sheeran.html";
        }
        else if(pos == 1)
        {
            url += "faded-lyrics-alan-walker.html";
        }
        else if(pos == 2)
        {
            url += "nina-lyrics-ed-sheeran.html";
        }
        else if(pos == 3)
        {
            url += "one-call-away-lyrics-charlie-puth.html";
        }
        else if(pos == 4)
        {
            url += "amnesia-lyrics-5-seconds-of-summer.html";
        }
        else if(pos == 5)
        {
            url += "pillow-talk-lyrics-zayn-malik.html";
        }
        else if(pos == 6)
        {
            url += "we-are-young-lyrics-fun.html";
        }
        else if(pos == 7)
        {
            url += "baby-youre-a-rich-man-lyrics-beatles.html";
        }
        else {        }
        position = pos;
        new Class5().execute();
    }

    public class Class5 extends AsyncTask<Void, Void, Void>{

        ProgressDialog progressDialog;
        String data1, data;
        String finalData = new String();

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(mainActivity);
            progressDialog.setMessage("Fetching Lyrics. . .");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            Document document = null;
            Elements e = null;
            //String finalData = new String();
            try {
                document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").get();
                e = document.select(".lyrics-body");
                data = e.text();
                String data2[] = data.split(" ");
                //String finalData = new String();
                for(int i = 0; i<data2.length; i++)
                {
                    if((int)data2[i].charAt(0) < 90 && (int)data2[i].charAt(0) >64)
                    {
                        finalData += "\n\n";
                    }
                    finalData += data2[i];
                    finalData += " ";
                }
            } catch (IOException ee) {
                data1 = ee.toString();
                ee.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            textView1.setText(string[position]);
            textView.setText(finalData);
            textView.setBackgroundResource(image[position]);
            textView.getBackground().setAlpha(100);
            textView.setMovementMethod(new ScrollingMovementMethod());
            progressDialog.dismiss();
        }
    }

}