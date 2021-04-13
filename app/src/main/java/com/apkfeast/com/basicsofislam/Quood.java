package com.apkfeast.com.basicsofislam;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;

public class Quood extends AppCompatActivity {

    ImageButton playattheyat, playdurrodibraheem,playrabjaelni;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quood);
        mp = new MediaPlayer();
        playattheyat = findViewById(R.id.playattheyat);
        playdurrodibraheem = findViewById(R.id.playdurrodibraheem);
        playrabjaelni = findViewById(R.id.playrabjaelni);

        playattheyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()){

                    mp = MediaPlayer.create(Quood.this, R.raw.tashhad);
                    mp.start();
                }
                else {
                    mp.stop();
                    mp.reset();
                    mp.start();
                }
            }
        });

        playdurrodibraheem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()){

                    mp = MediaPlayer.create(Quood.this, R.raw.durood);
                    mp.start();
                }
                else {
                    mp.stop();
                    mp.reset();
                    mp.start();
                }
            }

        });
        playrabjaelni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()){

                    mp = MediaPlayer.create(Quood.this, R.raw.rabjealni);
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