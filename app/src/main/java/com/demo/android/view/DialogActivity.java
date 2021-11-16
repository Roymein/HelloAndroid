package com.demo.android.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.demo.android.R;

public class DialogActivity extends AppCompatActivity {
    public static final String TAG = "ViewActivity";

    private ImageView mImageView;
    private ProgressBar mProgressBar;

    private TextView mTextViewShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mImageView = findViewById(R.id.iv_test);
        mProgressBar = findViewById(R.id.pb_test);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null && actionBar.isShowing()) {
            actionBar.hide();
        }
        mTextViewShow = findViewById(R.id.tv_show);
    }


    public void onClickAlertDialog(View view) {
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

    public void onClickProgressDialog(View view) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("ProgressDialog");
        progressDialog.setMessage("loading ……");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    public void onClickChangeImage(View view) {

        if (mProgressBar.getVisibility() == View.GONE) {
            mImageView.setImageResource(R.drawable.ic_launcher_foreground);
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onClickStartAnim(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400);
        valueAnimator.setDuration(10000);
        valueAnimator.addUpdateListener(animation -> {
            int value = (int) animation.getAnimatedValue();
            mTextViewShow.layout(value, value, value + mTextViewShow.getWidth(), value + mTextViewShow.getHeight());
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Log.e(TAG, "onAnimationEnd: " );
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                Log.e(TAG, "onAnimationStart: " );
            }
        });
        valueAnimator.start();
    }
}