package com.example.willbe.flowerpassword

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import com.example.willbe.flowerpassword.R

/**
 * Created by xpf on 2015/4/19.
 */
public class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)
        val manager = getFragmentManager()
        manager.beginTransaction().replace(R.id.container, PreferenceFragment()).commit()
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    companion object {


        private fun SHOW_PASS() = "show_pass"

        public fun isShowAfterEncryption(context: Context): Boolean {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getBoolean(SHOW_PASS(), true)

        }
    }
}