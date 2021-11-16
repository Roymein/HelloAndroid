package com.demo.android.customview;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.android.R;
import com.demo.android.view.CameraImageView;

public class ThressDActivity extends AppCompatActivity {
    private SeekBar mSeekBar;
    private CameraImageView mCameraImageView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thress_d);
        initView();
    }

    private void initView() {
        mTextView = findViewById(R.id.tv_process);
        mSeekBar = findViewById(R.id.sb_controller);
        mCameraImageView = findViewById(R.id.cv_cat);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mCameraImageView.setProgress(progress);
                mTextView.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}