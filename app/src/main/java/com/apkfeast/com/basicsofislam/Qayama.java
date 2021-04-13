package com.apkfeast.com.basicsofislam;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Qayama extends AppCompatActivity {

    MediaPlayer mp;
    ImageButton playqayam2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qayama);
        playqayam2 = findViewById(R.id.playqayam2);
        mp = new MediaPlayer();
        playqayam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()){

                    mp = MediaPlayer.create(Qayama.this, R.raw.qayam);
                    mp.start();
                }
                else {
                    mp.stop();
                    mp.reset();
                    mp.start();
                }
            }
        });

    }
}