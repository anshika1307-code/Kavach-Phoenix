package com.phoenix.wechatencryption;

import static android.os.Build.VERSION_CODES.O;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;

public class MainActivity extends AppCompatActivity {
    // in the below line, we are creating variables
   // final int REQUEST_CODE = 101;
   // String imei;

    Animation topAnim,bottomAnim,topAnim2;
    ImageView logo;
    TextView textView1,textView2;
    private static int SPLASH_SCREEN = 5000;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        topAnim2 = AnimationUtils.loadAnimation(this, R.anim.top_anim2);


        logo = findViewById(R.id.splash_logo);
        textView1=findViewById(R.id.text1);
        textView2=findViewById(R.id.text2);
        logo.setAnimation(topAnim);
        logo.setAnimation(topAnim2);
        textView1.setAnimation(bottomAnim);
        textView2.setAnimation(bottomAnim);


        //Hiding the Bottom Navigation Bar of System
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(MainActivity.this,imei_page.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}