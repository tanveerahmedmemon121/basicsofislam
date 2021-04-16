package com.apkfeast.com.basicsofislam;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Maintest extends AppCompatActivity {

    private CardView namaz, wudu, ablution, supplication;
    private Button copy, share;
    private TextView hadith;
    private SharedPreferences prefs;
    private boolean firstStart;


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
                Intent namaz = new Intent(Maintest.this, Namaz.class);
                startActivity(namaz);
            }
        });
        wudu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent namaz = new Intent(Maintest.this, Wudu.class);
                startActivity(namaz);
            }
        });

        ablution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent namaz = new Intent(Maintest.this, Ablution.class);
                startActivity(namaz);
            }
        });

        supplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent namaz = new Intent(Maintest.this, Suplications.class);
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

