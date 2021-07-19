package com.demo.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.demo.android.R;
import com.demo.android.playerview.MusicPlayerView;

public class AnimActivity extends AppCompatActivity {

    MusicPlayerView mpv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim2);

        initView();
    }

    private void initView() {
        mpv = (MusicPlayerView) findViewById(R.id.mpv);
        mpv.setCoverURL("https://upload.wikimedia.org/wikipedia/en/b/b3/MichaelsNumberOnes.JPG");

        mpv.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (mpv.isRotating()) {
                    mpv.stop();
                } else {
                    mpv.start();
                }
            }
        });
    }
}