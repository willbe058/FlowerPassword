package com.example.willbe.flowerpassword;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

/**
 * Created by xpf on 2015/4/19.
 */
public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private CheckBoxPreference checkBoxPreference;

    private static final String SHOW_PASS = "show_pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.setting);
        initPrefrenceActivity();
    }

    private void initPrefrenceActivity() {
        checkBoxPreference = ((CheckBoxPreference) findPreference(SHOW_PASS));

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Setup the initial values
        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
//        mListPreference.setSummary(sharedPreferences.getString(Consts.LIST_KEY, ""));
//        mEtPreference.setSummary(sharedPreferences.getString(Consts.EDIT_KEY, "linc"));

        // Set up a listener whenever a key changes
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the listener whenever a key changes
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        switch (key) {
            case SHOW_PASS:
//                checkBoxPreference
        }
    }

    public static boolean isShowAfterEncryption(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(SHOW_PASS, true);

    }
}
