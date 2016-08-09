package com.example.janerubygrissom.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.janerubygrissom.myapplication.services.MusicService;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mPlayer;

    Button mPlay;
    Button mPause;
    Button mStop;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlay = (Button) findViewById(R.id.play);
        mPause = (Button) findViewById(R.id.pause);
        mStop = (Button) findViewById(R.id.stop);

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicService.class);
                startService(intent);

            }


        });

        mPause.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                MusicService.pause();

            }


        });

        mStop.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                MusicService.stop();
                stopService(new Intent(MainActivity.this, MusicService.class));

            }


        });


    }


}
