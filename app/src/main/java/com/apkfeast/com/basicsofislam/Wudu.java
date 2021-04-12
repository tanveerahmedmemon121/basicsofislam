package com.apkfeast.com.basicsofislam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Wudu extends AppCompatActivity {

    AdView wudu1, wudu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wudu);
        wudu1 = findViewById(R.id.wuduad);
        wudu2 = findViewById(R.id.wuduad2);

        MobileAds.initialize(this, getString(R.string.APP_ID));
        wudu1.loadAd(new AdRequest.Builder().build());
        wudu2.loadAd(new AdRequest.Builder().build());


        InterstitialAd mad = new InterstitialAd(this);
        mad.setAdUnitId(getString(R.string.Inters));
        mad.loadAd(new AdRequest.Builder().build());
        if (mad.isLoaded()) {
            mad.show();
        }
    }
}
