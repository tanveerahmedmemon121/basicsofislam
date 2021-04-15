package com.apkfeast.com.basicsofislam;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;

import dm.audiostreamer.AudioStreamingManager;
import dm.audiostreamer.StreamingManager;

import static android.view.View.GONE;

public class DuaShow extends AppCompatActivity {
    String t1;
    ImageView play;
    MediaPlayer mp;
    StreamingManager streamingManager;
    String Url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dua_show);
        AdView adView = findViewById(R.id.duashowad);
        TextView title = findViewById(R.id.title);
        TextView dua1 = findViewById(R.id.dua1);
        play = findViewById(R.id.playdua);
        Button trans1 = findViewById(R.id.trans1);
        Button settings = findViewById(R.id.settings);
        MobileAds.initialize(DuaShow.this, getString(R.string.APP_ID));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        if (checkconnection()){
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Please enable data to play audio",Toast.LENGTH_LONG).show();
        }
// Set the media item to be played.


        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        assert bundle != null;
        String tit = bundle.getString("title");
        String d1 = bundle.getString("dua1");
        Url = bundle.getString("url");

        t1 = bundle.getString("trans1");
        int heigh = dua1.getLineCount() * dua1.getLineHeight();
        dua1.setHeight(heigh);
        int height = trans1.getLineCount() * trans1.getLineHeight();
        trans1.setHeight(height);
        dua1.setMovementMethod(ScrollingMovementMethod.getInstance());

        title.setText(tit);
        mp = new MediaPlayer();


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()&& checkconnection()) {

                    Toast.makeText(DuaShow.this, "Loading audio....", Toast.LENGTH_SHORT).show();

                    try {

                        Uri myUri = Uri.parse(Url);
                        System.out.println(myUri);
                        mp.setDataSource(v.getContext(), myUri);
                        mp.prepare();
                        play.setVisibility(GONE);
                        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer playerM) {
                                playerM.start();


                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {

                        mp.reset();
                        play.setVisibility(View.VISIBLE);
                    }
                });

            }

        });


        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.reset();

            }
        });

// Prepare the player.


        if (d1 != null) {
            dua1.setText(d1);
        }

//        if (t1 != null) {
//            trans1.setText(t1);
//        }

        trans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(DuaShow.this);
                alert.setTitle("Translation");
                alert.setMessage(t1);
                alert.setCancelable(true);
                alert.create().show();
            }
        });


        dua1.setTextDirection(View.TEXT_DIRECTION_ANY_RTL);

        trans1.setTextDirection(View.TEXT_DIRECTION_ANY_RTL);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeLanguage();
            }
        });

    }

    private void ChangeLanguage() {


        Intent set = new Intent(DuaShow.this, Setting.class);
        startActivity(set);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
        if (streamingManager != null) {
            streamingManager.onStop();
        }
    }

    private boolean checkconnection(){

        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

    }

