package com.demo.android.activity.launchmode;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.demo.android.R;

public class LaunchModeActivity extends AppCompatActivity {
    public static final String TAG = "LaunchModeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new EmbossMaskFilterView(this));
        setContentView(R.layout.activity_launch_mode);
        Log.e(TAG, "onCreate: " + getClass().getSimpleName() + this.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " + getClass().getSimpleName() + this.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " + getClass().getSimpleName() + this.toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " + getClass().getSimpleName() + this.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " + getClass().getSimpleName() + this.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " + getClass().getSimpleName() + this.toString());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " + getClass().getSimpleName() + this.toString());
    }


    public void onClickLaunchActivity(View view) {
        jumpToActivity(LaunchModeActivity1.class);
    }

    public void onClickLaunchActivity1(View view) {
        jumpToActivity(LaunchModeActivity2.class);
    }

    public void onClickLaunchActivity2(View view) {
        jumpToActivity(LaunchModeActivity3.class);
    }

    private void jumpToActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("AlertDialog")
                .setMessage("something important ……")
                .setCancelable(false)
                .setPositiveButton("sure", (dialog, which) -> {

                })
                .setNegativeButton("cancel", (dialog, which) -> {

                });
        builder.show();
    }
}