package com.apkfeast.com.basicsofislam;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Sajda extends AppCompatActivity {

    MediaPlayer mp;
    ImageButton playsajda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sajda);

        playsajda = findViewById(R.id.playsajda);
        mp = new MediaPlayer();
        playsajda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()){

                    mp = MediaPlayer.create(Sajda.this, R.raw.sajdah);
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