package com.apkfeast.com.basicsofislam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class Qayam extends AppCompatActivity {


    ImageButton plasana,playbism,playfatiha,playqulhuwallah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qayam);

        plasana = findViewById(R.id.plasana);
        playbism = findViewById(R.id.playbism);
        playfatiha = findViewById(R.id.playfatiha);
        playqulhuwallah = findViewById(R.id.playqulhuwallah);
    }
}