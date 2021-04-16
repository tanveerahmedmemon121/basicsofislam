package com.apkfeast.com.basicsofislam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Namaz extends AppCompatActivity {

    private CardView takbeer, qayyam, ruku, qayama, sajda, quood, salam;
    private AdView NAMAZAD;
    private InterstitialAd iad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.namazt);
        InitializeUI();

        takbeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Namaz.this, Takbeer.class);
                startActivity(i);
            }
        });
        qayyam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Namaz.this, Qayam.class);
                startActivity(i);
            }
        });
        ruku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Namaz.this, Ruku.class);
                startActivity(i);
            }
        });
        qayama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Namaz.this, Qayama.class);
                startActivity(i);
            }
        });
        sajda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Namaz.this, Sajda.class);
                startActivity(i);
            }
        });

        quood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Namaz.this, Quood.class);
                startActivity(i);

            }
        });
        salam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Namaz.this, Salam.class);
                startActivity(i);

            }
        });


//        MobileAds.initialize(this,getString(R.string.APP_ID));
//        namazad1.loadAd(new AdRequest.Builder().build());
//        namazad.loadAd(new AdRequest.Builder().build());
//
//
//        mp = new MediaPlayer();
//        akbr.setOnClickListener(this);
//        sana.setOnClickListener(this);
//        bismauz.setOnClickListener(this);
//        ruku.setOnClickListener(this);
//        fatiha.setOnClickListener(this);
//        qulhu.setOnClickListener(this);
//        qayam2.setOnClickListener(this);
//        sajda.setOnClickListener(this);
//        ataheya.setOnClickListener(this);
//        durood.setOnClickListener(this);
//        rabjelni.setOnClickListener(this);
//        salam.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//
//            case R.id.playakbr:
//                rawid = R.raw.akbar;
//                break;
//            case R.id.plasana:
//                rawid = R.raw.sana;
//                break;
//            case R.id.playbism:
//                rawid = R.raw.bism;
//                break;
//            case R.id.playfatiha:
//                rawid = R.raw.fatiha;
//                break;
//            case R.id.playqulhuwallah:
//                rawid = R.raw.ikhlas;
//                break;
//            case R.id.playqayam2:
//                rawid = R.raw.qayam;
//                break;
//            case R.id.playrukoo:
//                rawid = R.raw.rukoo;
//                break;
//            case R.id.playsajda:
//                rawid = R.raw.sajdah;
//                break;
//            case R.id.playattheyat:
//                rawid = R.raw.tashhad;
//                break;
//            case R.id.playdurrodibraheem:
//                rawid = R.raw.durood;
//                break;
//            case R.id.playrabjaelni:
//                rawid = R.raw.rabjealni;
//                break;
//            case R.id.playsalam:
//                rawid = R.raw.salam;
//                break;
//        }
//        if (!mp.isPlaying()){
//            mp = MediaPlayer.create(Namaz.this,rawid);
//            mp.start();}
//
//        else {
//            mp.stop();
//            mp.reset();
//            mp.start();
//        }
//
//    }
//
//
//
//    private void InitializeUI(){
//
//        akbr = findViewById(R.id.playakbr);
//        sana = findViewById(R.id.plasana);
//        bismauz = findViewById(R.id.playbism);
//        fatiha = findViewById(R.id.playfatiha);
//        qulhu = findViewById(R.id.playqulhuwallah);
//        qayam2 = findViewById(R.id.playqayam2);
//        ruku = findViewById(R.id.playrukoo);
//        sajda = findViewById(R.id.playsajda);
//        ataheya = findViewById(R.id.playattheyat);
//        durood = findViewById(R.id.playdurrodibraheem);
//        rabjelni = findViewById(R.id.playrabjaelni);
//        salam = findViewById(R.id.playsalam);
//        namazad = findViewById(R.id.namazad);
//        namazad1 = findViewById(R.id.namazad2);
//


    }

    private void InitializeUI() {


        takbeer = findViewById(R.id.takbeer);
        qayyam = findViewById(R.id.qayam);
        ruku = findViewById(R.id.rukoo);
        qayama = findViewById(R.id.qayama);
        sajda = findViewById(R.id.sajda);
        quood = findViewById(R.id.quood);
        salam = findViewById(R.id.salam);
    }


}

