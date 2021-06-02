package com.demo.android.layout;


import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.demo.android.R;

public class TitleLayout extends LinearLayout {

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout, this);

        Button btnBack = findViewById(R.id.btn_back);
        Button btnEdit = findViewById(R.id.btn_edit);

        btnBack.setOnClickListener(v -> {
            ((Activity) getContext()).finish();
        });

        btnEdit.setOnClickListener(v -> {
            Toast.makeText(getContext(), "edit ", Toast.LENGTH_SHORT).show();
        });
    }
}