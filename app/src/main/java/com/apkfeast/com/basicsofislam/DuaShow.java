package com.apkfeast.com.basicsofislam;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class DuaShow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dua_show);
        AdView adView = findViewById(R.id.duashowad);
        TextView title = findViewById(R.id.title);
        TextView dua1 = findViewById(R.id.dua1);
        TextView trans1 = findViewById(R.id.trans1);
        Button settings = findViewById(R.id.settings);
        MobileAds.initialize(DuaShow.this, getString(R.string.APP_ID));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        assert bundle != null;
        String tit = bundle.getString("title");
        String d1 = bundle.getString("dua1");

        String t1 = bundle.getString("trans1");
        int heigh = dua1.getLineCount() * dua1.getLineHeight();
        dua1.setHeight(heigh);
        int height = trans1.getLineCount() * trans1.getLineHeight();
        trans1.setHeight(height);
        dua1.setMovementMethod(ScrollingMovementMethod.getInstance());

        title.setText(tit);

        if (d1 != null) {
            dua1.setText(d1);
        }

        if (t1 != null) {
            trans1.setText(t1);
        }


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
}
