package com.example.rishabh.symphony;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class _Fragment1_ extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {


    String string[] = {"Ed Sheeran - Thinking Out Loud", "Alan Walker - Faded", "Ed Sheeran - Nina", "Charlie Puth - One Call Away", "5SOS - Amnesia", "Zayn - PillowTalk", "Fun - We are Young", "Beatles - Baby you're a rich man"};


    boolean variable = true;
    TextView t1, t2, t3;
    MainActivity mainActivity;
    SeekBar seekBar;
    Button b1, b2, b3, b4;
    MediaPlayer mediaPlayer;
    int change = 4000;
    int flag = 0;
    Thread thread;
    int min, sec;
    _Fragment4_ fragment4_;

    @SuppressLint("ValidFragment")
    public _Fragment1_(MainActivity mainActivity, _Fragment4_ fragment4_) {

        this.mainActivity = mainActivity;
        this.fragment4_ = fragment4_;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity___fragment1_, container, false);
        b1 = (Button) view.findViewById(R.id.button);    //PLAY
        b2 = (Button) view.findViewById(R.id.button2);    //REWIND
        b3 = (Button) view.findViewById(R.id.button3);    //FORWARD
        b4 = (Button) view.findViewById(R.id.button4);    //STOP
        t1 = (TextView) view.findViewById(R.id.textView);
        t2 = (TextView) view.findViewById(R.id.textView2);
        t3 = (TextView) view.findViewById(R.id.textView3);
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);
        mediaPlayer = MediaPlayer.create(mainActivity, R.raw.thinking);
        seekBar.setMax(mediaPlayer.getDuration() / 1000);
        t3.setText("Ed Sheeran - Thinking Out Loud");
        return view;
    }

    @Override
    public void onClick(View v) {

        if(v == b1)
        {
            if(flag == 0) {
                mediaPlayer.start();
                flag = 1;
                b1.setText("||");
                thread = new Thread(new Class1());
                thread.start();
            }
            else
            {
                b1.setText("|>");
                mediaPlayer.pause();
                flag = 0;
            }
            //seekBar.setProgress(1);
        }
        if(v == b2)
        {
            int temp = mediaPlayer.getCurrentPosition() - change;
            if(temp > 0) {
                mediaPlayer.seekTo(temp);
            }
            else
            {
                mediaPlayer.seekTo(0);
            }
        }
        if(v == b3)
        {
            int temp = mediaPlayer.getCurrentPosition() + change;
            if(temp < mediaPlayer.getDuration()) {
                mediaPlayer.seekTo(temp);
            }
            else
            {
                mediaPlayer.seekTo(mediaPlayer.getDuration());
            }
        }
        if(v == b4)
        {
            seekBar.setProgress(0);
            mediaPlayer.seekTo(0);
            mediaPlayer.pause();
            flag = 0;
            b1.setText("|>");
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        //seekBar.setProgress(mediaPlayer.getCurrentPosition()/1000);
        //Toast.makeText(mainActivity, ""+(mediaPlayer.getDuration()/1000), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        variable = false;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        mediaPlayer.pause();
        int pos = seekBar.getProgress();
        //this.seekBar.setProgress(pos);
        //mediaPlayer.pause();
        variable = true;
        mediaPlayer.seekTo(pos * 1000);
        //Toast.makeText(mainActivity, ""+pos+" and : "+mediaPlayer.getCurrentPosition()/1000, Toast.LENGTH_SHORT).show();
        thread = new Thread(new Class1());
        mediaPlayer.start();
        thread.start();
    }

    public void playSong(int position) {
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
        }
        if(position == 0)
        {
            mediaPlayer = MediaPlayer.create(mainActivity, R.raw.thinking);
        }

        if(position == 1)
        {
            mediaPlayer = MediaPlayer.create(mainActivity, R.raw.faded);

        }
        if(position == 2)
        {
            mediaPlayer = MediaPlayer.create(mainActivity, R.raw.nina);
        }
        if(position == 3)
        {
            mediaPlayer = MediaPlayer.create(mainActivity, R.raw.puth);
        }
        if(position == 4)
        {
            mediaPlayer = MediaPlayer.create(mainActivity, R.raw.sos);
        }
        if(position == 5)
        {
            mediaPlayer = MediaPlayer.create(mainActivity, R.raw.zayn);
        }
        if(position == 6)
        {
            mediaPlayer = MediaPlayer.create(mainActivity, R.raw.fun);
        }
        if(position == 7)
        {
            mediaPlayer = MediaPlayer.create(mainActivity, R.raw.baby);
        }
        seekBar.setMax(mediaPlayer.getDuration() / 1000);
        min = (mediaPlayer.getDuration()/1000)/60;
        sec = (mediaPlayer.getDuration()/1000)%60;
        t1.setText("00:00");
        t2.setText(min + ":" + sec);
        t3.setText(string[position]);
        mediaPlayer.start();
        flag = 1;
        b1.setText("||");
        fragment4_.showLyrics(position);
        thread = new Thread(new Class1());
        thread.start();

    }

    public class Class1 implements Runnable
    {
        @Override
        public void run() {
            while(mediaPlayer.isPlaying() && variable == true)
            {
                int pos1 = mediaPlayer.getCurrentPosition()/1000;
                seekBar.setProgress(pos1);
                /*int min = pos1/60;
                int sec = pos1%60;
                try {
                    t1.setText(min + ":" + sec);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }*/
            }
        }
    }

}