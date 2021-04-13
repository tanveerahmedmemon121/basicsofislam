package com.apkfeast.com.basicsofislam;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Qayam extends AppCompatActivity {


    ImageButton plasana, playbism, playfatiha, playqulhuwallah;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qayam);

        plasana = findViewById(R.id.plasana);
        playbism = findViewById(R.id.playbism);
        playfatiha = findViewById(R.id.playfatiha);
        playqulhuwallah = findViewById(R.id.playqulhuwallah);
        mp = new MediaPlayer();

        plasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()) {
                    mp = MediaPlayer.create(Qayam.this, R.raw.sana);
                    mp.start();
                } else {
                    mp.stop();
                    mp.reset();
                    mp.start();
                }
            }
        });

        playbism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()) {
                    mp = MediaPlayer.create(Qayam.this, R.raw.bism);
                    mp.start();
                } else {
                    mp.stop();
                    mp.reset();
                    mp.start();
                }


            }
        });
        playfatiha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()) {
                    mp = MediaPlayer.create(Qayam.this, R.raw.fatiha);
                    mp.start();
                } else {
                    mp.stop();
                    mp.reset();
                    mp.start();
                }
            }
        });

        playqulhuwallah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()) {
                    mp = MediaPlayer.create(Qayam.this, R.raw.ikhlas);
                    mp.start();
                } else {
                    mp.stop();
                    mp.reset();
                    mp.start();
                }
            }
        });
    }
}