package com.demo.android.activity.launchmode;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.demo.android.R;

public class LaunchModeActivity1 extends AppCompatActivity {
    public static final String TAG = "LaunchModeActivity1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode1);
        Log.e(TAG, "onCreate: "+  getClass().getSimpleName() + this.toString() );
    }
}