package com.apkfeast.com.basicsofislam;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private CardView namaz, wudu, ablution, supplication;
    private Button copy, share;
    private TextView hadith;
    private SharedPreferences prefs;
    private boolean firstStart;
    ImageView namazimage , sup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testmain);
        InitializeUI();
        Setprefs();
        if (firstStart){
            showStartDialog();
        }



        namaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent namaz = new Intent(MainActivity.this, Namaz.class);
                startActivity(namaz);
            }
        });
        wudu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent namaz = new Intent(MainActivity.this, Wudu.class);
                startActivity(namaz);
            }
        });

        ablution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent namaz = new Intent(MainActivity.this, Ablution.class);
                startActivity(namaz);
            }
        });

        supplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent namaz = new Intent(MainActivity.this, Suplications.class);
                startActivity(namaz);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Share();
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Copy();
            }
        });
    }

    private void InitializeUI() {
        namaz = findViewById(R.id.LearnNamaz);
        wudu = findViewById(R.id.qayam);
        ablution = findViewById(R.id.ablution);
        supplication = findViewById(R.id.supp);
        hadith = findViewById(R.id.hadith);
        copy = findViewById(R.id.copy);
        share = findViewById(R.id.share);
        namazimage = findViewById(R.id.namaz);
        sup = findViewById(R.id.sup);

        Glide.with(this)
                .load(R.drawable.namaz)
                .into(namazimage);
        Glide.with(this).
                load(R.drawable.supplication).
                into(sup);
    }

    private void Share() {
        String share = hadith.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, share);
        startActivity(Intent.createChooser(intent, "Share with"));
    }


    private void Copy() {

        String s = hadith.getText().toString();
        ClipboardManager clip = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData data = ClipData.newPlainText(s, s);
        clip.setPrimaryClip(data);
        Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
    }

    private void Setprefs() {
        prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        firstStart = prefs.getBoolean("firstStart", true);
    }
    private void showStartDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Translation issue")
                .setMessage(getString(R.string.alert))
                .setCancelable(false)
                .setPositiveButton("Ok I understood", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }
}





























//package com.apkfeast.com.basicsofislam;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private AdView smartbanner;
//    private InterstitialAd iad;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Button sup = findViewById(R.id.dua);
//        sup.setOnClickListener(this);
//        Button ablution = findViewById(R.id.ablution);
//        ablution.setOnClickListener(this);
//        Button wudu = findViewById(R.id.wudu);
//        wudu.setOnClickListener(this);
//        Button namaz = findViewById(R.id.namaz);
//        namaz.setOnClickListener(this);
////        ImageView disc = findViewById(R.id.disc);
////        ImageView cont = findViewById(R.id.cont);
////        disc.setOnClickListener(this);
////        cont.setOnClickListener(this);
//        //Save Boolean to know if user has started app first time
//        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
//        boolean firstStart = prefs.getBoolean("firstStart", true);
//
//        AdmobAds();
//        LoadInterstitial();
//
//
//        if (firstStart) {
//            showStartDialog();
//        }
//
//        AdListener listener = new AdListener() {
//
//            @Override
//            public void onAdClosed() {
//                super.onAdClosed();
//                finish();
//            }
//
//            @Override
//            public void onAdFailedToLoad(int i) {
//                super.onAdFailedToLoad(i);
//                Log.d("Ads", "Failed to load Ad");
//            }
//
//            @Override
//            public void onAdLeftApplication() {
//                super.onAdLeftApplication();
//
//            }
//
//            @Override
//            public void onAdOpened() {
//                super.onAdOpened();
//            }
//
//            @Override
//            public void onAdLoaded() {
//                super.onAdLoaded();
//            }
//
//            @Override
//            public void onAdClicked() {
//                super.onAdClicked();
//            }
//
//            @Override
//            public void onAdImpression() {
//                super.onAdImpression();
//            }
//        };
//        iad.setAdListener(listener);
//    }
//
//    //TO Load ADMOB Ads
//    private void AdmobAds() {
//
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//
//            }
//        });
//
//        smartbanner = findViewById(R.id.menuad);
//        smartbanner.loadAd(new AdRequest.Builder().build());
//
//
//    }
//
//    private void showStartDialog() {
//        new AlertDialog.Builder(this)
//                .setTitle("Translation issue")
//                .setMessage(getString(R.string.alert))
//                .setCancelable(false)
//                .setPositiveButton("Ok I understood", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                })
//                .create().show();
//
//        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putBoolean("firstStart", false);
//        editor.apply();
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//
//            case R.id.dua:
//                OpenDua();
//                break;
//
//            case R.id.ablution:
//                OpenAblution();
//                break;
//            case R.id.wudu:
//                OpenWudu();
//                break;
//            case R.id.namaz:
//                OpenNamaz();
//                break;
////            case R.id.disc:
////                OpenDisclaimer();
////                break;
////            case R.id.cont:
////                SendEmail();
////                break;
//        }
//    }
//
//    private void SendEmail() {
//
//        Intent intent = new Intent(Intent.ACTION_SEND);
//
//        intent.setType("message/rfc822");
//
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"maddeveloper999@gmail.com"});
//
//        intent.putExtra(Intent.EXTRA_SUBJECT, "App Feedback");
//
//        intent.putExtra(Intent.EXTRA_TEXT, "");
//
//        startActivity(Intent.createChooser(intent, "Send Email"));
//    }
//
//
//    private void OpenNamaz() {
//        Intent namaz = new Intent(MainActivity.this, Namaz.class);
//        startActivity(namaz);
//        ShowAds();
//    }
//
//    private void OpenWudu() {
//
//        Intent wudu = new Intent(MainActivity.this, Wudu.class);
//        startActivity(wudu);
//        ShowAds();
//
//    }
//
//    private void OpenAblution() {
//
//        Intent ablution = new Intent(MainActivity.this, Ablution.class);
//        startActivity(ablution);
//        ShowAds();
//
//    }
//
//    private void OpenDua() {
//        Intent dua = new Intent(MainActivity.this, Suplications.class);
//        startActivity(dua);
//        ShowAds();
//
//    }
//
//    //To load Interstial Ads
//    private void LoadInterstitial() {
//
//        iad = new InterstitialAd(this);
//        iad.setAdUnitId(getString(R.string.Inters));
//        iad.loadAd(new AdRequest.Builder().build());
//    }
//
//    @Override
//    public void onBackPressed() {
//
//
//        if (iad.isLoaded()) {
//            iad.show();
//        } else {
//            finish();
//        }
//    }
//
//    private void ShowAds() {
//
//        if (iad.isLoaded()) {
//            iad.show();
//        }
//    }
//}
