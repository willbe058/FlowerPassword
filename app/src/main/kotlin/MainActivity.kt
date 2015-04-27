package com.example.willbe.flowerpassword

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.willbe.flowerpassword.EncryptionArithmetic.Ecryption
import com.example.willbe.flowerpassword.R

import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import java.io.UnsupportedEncodingException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException

public class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var memPassET: EditText? = null
    private var keyWordET: EditText? = null
    private var menu: FloatingActionMenu? = null
    private var encryptButton: FloatingActionButton? = null
    private var display: TextView? = null
    //    private Button copyBtn;
    private var finalPass: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun MainActivity.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }

    private fun<T> id(id: Int): T {
        return findViewById(id) as T

    }

    private fun initView() {
        memPassET = id(R.id.mem_pass)

//        memPassET = (findViewById(R.id.mem_pass) as EditText)
        keyWordET = (findViewById(R.id.keyword) as EditText)
        menu = (findViewById(R.id.menu) as FloatingActionMenu)
        encryptButton = (findViewById(R.id.encryptItem1) as FloatingActionButton)
        display = findViewById(R.id.finalPass) as TextView
        //        copyBtn = (Button) findViewById(R.id.copy);
        //        copyBtn.setOnClickListener(this);
        encryptButton!!.setOnClickListener(this)

    }


    private fun copy(content: String, context: Context) {
        val manager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        manager.setPrimaryClip(ClipData.newPlainText("password", content))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item!!.getItemId()

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(Intent(this, javaClass<SettingsActivity>()))
            //            return true;
        }

        return super<AppCompatActivity>.onOptionsItemSelected(item)
    }

    override fun onClick(v: View) {
        when (v.getId()) {
            R.id.encryptItem1 -> {
                val memPass = memPassET!!.getText().toString()
                val keyWord = keyWordET!!.getText().toString()
                if (memPass != "" && keyWord != "") {
                    try {
                        finalPass = Ecryption.encyptWithFlowerPass(memPass, keyWord)
                        display!!.setText(finalPass)
                        menu!!.close(true)
                        if (finalPass != "") {
                            copy(finalPass as String, this)

                            toast("Copied")

                        } else {
                            toast("Nothing!")

                        }
                        if (!SettingsActivity.isShowAfterEncryption(this)) {
                            onBackPressed()
                        }

                    } catch (e: UnsupportedEncodingException) {
                        e.printStackTrace()
                    } catch (e: NoSuchAlgorithmException) {
                        e.printStackTrace()
                    } catch (e: InvalidKeyException) {
                        e.printStackTrace()
                    }

                } else {
                    toast("No input at all! Are you kidding me? ")
                }
            }
        }//            case R.id.copy:
        //                if (finalPass != null) {
        //                    copy(finalPass, this);
        //                    Toast.makeText(this, "Copied!", Toast.LENGTH_LONG).show();
        //                } else {
        //                    Toast.makeText(this, "Nothing!", Toast.LENGTH_LONG).show();
        //                }
    }
}