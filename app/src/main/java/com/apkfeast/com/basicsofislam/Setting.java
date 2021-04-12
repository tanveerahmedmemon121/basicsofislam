package com.apkfeast.com.basicsofislam;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Locale;

public class Setting extends AppCompatActivity {
    PrefData data;
    AdView adView;
    private Context con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        adView = findViewById(R.id.setads);

        MobileAds.initialize(this, getString(R.string.APP_ID));
        adView.loadAd(new AdRequest.Builder().build());

        con = getApplicationContext();
        data = new PrefData(con);
        Spinner spinner = findViewById(R.id.langspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.language_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 1:
                        setLanguage("af");
                        break;
                    case 2:
                        setLanguage("az");
                        break;
                    case 3:
                        setLanguage("bn");
                        break;
                    case 4:
                        setLanguage("hi");
                        break;
                    case 5:
                        setLanguage("jv");
                        break;
                    case 6:
                        setLanguage("ms");
                        break;
                    case 7:
                        setLanguage("pa");
                        break;
                    case 8:
                        setLanguage("ps");
                        break;
                    case 9:
                        setLanguage("sd");
                        break;
                    case 10:
                        setLanguage("su");
                        break;
                    case 11:
                        setLanguage("sw");
                        break;
                    case 12:
                        setLanguage("ur");
                        break;
                    case 13:
                        setLanguage("en");
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setLanguage(String language) {

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }
        con.getApplicationContext().getResources().updateConfiguration(config, null);
        data.setCurrentLanguage(language);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();


    }
}


