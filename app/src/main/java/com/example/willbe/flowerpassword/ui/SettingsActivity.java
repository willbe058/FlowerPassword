package com.example.willbe.flowerpassword.ui;

import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;

import com.example.willbe.flowerpassword.R;

/**
 * Created by xpf on 2015/4/19.
 */
public class SettingsActivity extends ActionBarActivity {


    private static final String SHOW_PASS = "show_pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.container, new PreferenceFragment()).commit();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public static boolean isShowAfterEncryption(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(SHOW_PASS, true);

    }
}
