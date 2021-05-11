package com.demo.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.demo.android.activity.GridLayoutActivity;
import com.demo.android.activity.TableLayoutActivity;
import com.demo.android.activity.TextInputLayoutActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTableLayout(View view) {
        Intent intent = new Intent(this, TableLayoutActivity.class);
        startActivity(intent);
    }

    public void onClickEditManagedByTextInputLayout(View view) {
        Intent intent = new Intent(this, TextInputLayoutActivity.class);
        startActivity(intent);
    }

    public void onClickGridLayout(View view) {
        Intent intent = new Intent(this, GridLayoutActivity.class);
        startActivity(intent);
    }

    public void onClickRelativeLayout(View view) {

    }
}