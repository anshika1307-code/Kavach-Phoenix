package com.phoenix.wechatencryption;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class imei_page extends AppCompatActivity {
    TextView s1,s2;
    Button btn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imei_page);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, PackageManager.PERMISSION_GRANTED);
        s1=findViewById(R.id.idTVIMEI1);
        s2=findViewById(R.id.idTVIMEI2);
        btn=findViewById(R.id.check);
        //  TelephonyManager telephonyManager=(TelephonyManager) this.getSystemService(this.TELEPHONY_SERVICE);


        //      imei=telephonyManager.getImei(2);

        //  s.setText(imei);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deviceId1 = null;
                String deviceId2 = null;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    deviceId1 = Settings.Secure.getString(getContentResolver(),
                            Settings.Secure.ANDROID_ID);
                } else {
                    final TelephonyManager mTelephony = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                    if (mTelephony.getDeviceId() != null) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            deviceId1 = mTelephony.getDeviceId(1);
                            deviceId2=mTelephony.getDeviceId(2);
                        }
                    } else {
                        deviceId1 = Settings.Secure.getString(getContentResolver(),
                                Settings.Secure.ANDROID_ID);
                    }
                }

                s1.setText("Slot-1\n"+deviceId1);
                s2.setText("Slot-2\n"+deviceId2);


            }
        });













    }

}