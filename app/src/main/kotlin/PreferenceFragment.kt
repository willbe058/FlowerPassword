package com.example.willbe.flowerpassword

import android.os.Bundle
import android.preference.PreferenceFragment
import com.example.willbe.flowerpassword.R

/**
 * Created by xpf on 2015/4/20.
 */
public class PreferenceFragment : PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.setting)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}