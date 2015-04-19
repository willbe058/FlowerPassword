package com.example.willbe.flowerpassword;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.willbe.flowerpassword.EncryptionArithmetic.Ecryption;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private EditText memPassET;
    private EditText keyWordET;
    private FloatingActionMenu menu;
    private FloatingActionButton encryptButton;
    private TextView display;
    //    private Button copyBtn;
    private String finalPass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        memPassET = ((EditText) findViewById(R.id.mem_pass));
        keyWordET = ((EditText) findViewById(R.id.keyword));
        menu = ((FloatingActionMenu) findViewById(R.id.menu));
        encryptButton = ((FloatingActionButton) findViewById(R.id.encryptItem1));
        display = (TextView) findViewById(R.id.finalPass);
//        copyBtn = (Button) findViewById(R.id.copy);
//        copyBtn.setOnClickListener(this);
        encryptButton.setOnClickListener(this);

    }


    private void copy(String content, Context context) {
        ClipboardManager manager = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
        manager.setPrimaryClip(ClipData.newPlainText("password", content));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
//            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.encryptItem1:
                String memPass = memPassET.getText().toString();
                String keyWord = keyWordET.getText().toString();
                if (memPass != null && keyWord != null && !memPass.equals("") && !keyWord.equals("")) {
                    try {
                        finalPass = Ecryption.encyptWithFlowerPass(memPass, keyWord);
                        display.setText(finalPass);
                        menu.close(true);
                        if (finalPass != null) {
                            copy(finalPass, this);
                            Toast.makeText(this, "Copied!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(this, "Nothing!", Toast.LENGTH_LONG).show();
                        }

                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    } catch (InvalidKeyException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(this, "No input at all! Are you kidding me? ", Toast.LENGTH_LONG).show();
                }
                break;
//            case R.id.copy:
//                if (finalPass != null) {
//                    copy(finalPass, this);
//                    Toast.makeText(this, "Copied!", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(this, "Nothing!", Toast.LENGTH_LONG).show();
//                }
        }
    }
}
