package com.apkfeast.com.basicsofislam;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Ruku extends AppCompatActivity {


    ImageButton playrukoo;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ruku);
        playrukoo = findViewById(R.id.playrukoo);
        mp = new MediaPlayer();
        playrukoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()){

                    mp = MediaPlayer.create(Ruku.this, R.raw.rukoo);
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