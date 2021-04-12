package com.apkfeast.com.basicsofislam;

import android.content.Context;
import android.content.SharedPreferences;

import static com.apkfeast.com.basicsofislam.Constants.PREF_LANG;
import static com.apkfeast.com.basicsofislam.Constants.PREF_NAME;


/**
 * Created by y34h1a on 1/13/16.
 */
class PrefData {
    private final SharedPreferences pref;
    private final SharedPreferences.Editor editor;

    // Shared pref mode
    private final int PRIVATE_MODE = 0;

    public PrefData(Context context) {
        Context _context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public String getCurrentLanguage() {
        return pref.getString(PREF_LANG, "eng");
    }

    public void setCurrentLanguage(String language) {
        editor.putString(PREF_LANG, language);
        editor.commit();
    }

}