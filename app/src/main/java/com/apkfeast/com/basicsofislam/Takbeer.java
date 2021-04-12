package com.apkfeast.com.basicsofislam;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Takbeer extends AppCompatActivity {


    MediaPlayer mp;
    ImageButton playakbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takbeer);
        mp = new MediaPlayer();
        playakbr = findViewById(R.id.playakbr);
        playakbr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()) {
                    mp = MediaPlayer.create(Takbeer.this, R.raw.akbar);
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