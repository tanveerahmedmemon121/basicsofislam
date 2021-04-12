package com.apkfeast.com.basicsofislam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Ablution extends AppCompatActivity {

    AdView ablutionad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ablution);
        ablutionad = findViewById(R.id.ablutionad);
        MobileAds.initialize(this, getString(R.string.APP_ID));
        ablutionad.loadAd(new AdRequest.Builder().build());

        InterstitialAd mad = new InterstitialAd(this);
        mad.setAdUnitId(getString(R.string.Inters));
        mad.loadAd(new AdRequest.Builder().build());
        if (mad.isLoaded()) {
            mad.show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
