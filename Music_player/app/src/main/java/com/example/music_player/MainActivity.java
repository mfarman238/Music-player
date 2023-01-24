package com.example.music_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnpause , btnplay, btnstop;

        btnpause = findViewById(R.id.btnpause);
        btnplay = findViewById(R.id.btnplay);
        btnstop = findViewById(R.id.btnstop);


        MediaPlayer mp = new MediaPlayer();

        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String apath = "android.resource://"+getPackageName()+"/raw/shiddat";

        Uri audiouri = Uri.parse(apath);

        try {
            mp.setDataSource(this,audiouri);
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.seekTo(0);
            }
        });


    }
}