package com.example.willbe.flowerpassword.ui;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.willbe.flowerpassword.R;

/**
 * Created by xpf on 2015/4/20.
 */
public class PreferenceFragment extends android.preference.PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
