package com.demo.android.activity;

import android.os.Bundle;

import com.demo.android.R;
import com.demo.lib.activity.BaseActivity;

public class RelativeLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_relative_layout);
    }

    @Override
    protected void init() {

    }
}