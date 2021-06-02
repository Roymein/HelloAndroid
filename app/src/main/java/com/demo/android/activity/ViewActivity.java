package com.demo.android.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.demo.android.R;

public class ViewActivity extends AppCompatActivity {
    private ImageView mImageView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mImageView = findViewById(R.id.iv_test);
        mProgressBar = findViewById(R.id.pb_test);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null && actionBar.isShowing()) {
            actionBar.hide();
        }
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

}