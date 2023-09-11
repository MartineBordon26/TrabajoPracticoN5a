package com.martinbordon.trabajopracticon5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    BroadcastLlamar ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
        registrarBroadcast();
    }


    private void registrarBroadcast() {
        this.ba = new BroadcastLlamar();
        registerReceiver(this.ba, new IntentFilter("android.net.wifi.supplicant.CONNECTION_CHANGE"));
    }

   @Override
   protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.ba);
    }
}