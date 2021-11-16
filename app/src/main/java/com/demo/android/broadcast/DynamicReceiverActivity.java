package com.demo.android.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;

import com.demo.android.R;
import com.demo.android.broadcast.DynamicReceiver;

public class DynamicReceiverActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private DynamicReceiver dynamicReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_receiver);
        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        intentFilter.addAction("test");
        dynamicReceiver = new DynamicReceiver();
        registerReceiver(dynamicReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicReceiver);
    }

    public void onClickNetWorkChanged(View view) {
        Intent intent = new Intent();
        intent.setAction("test");
        sendBroadcast(intent);

    }
}