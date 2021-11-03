package com.demo.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.android.activity.AnimActivity;
import com.demo.android.activity.CustomViewActivity;
import com.demo.android.activity.DynamicReceiverActivity;
import com.demo.android.activity.GridLayoutActivity;
import com.demo.android.activity.LaunchModeActivity;
import com.demo.android.activity.ListViewActivity;
import com.demo.android.activity.MenuActivity;
import com.demo.android.activity.RelativeLayoutActivity;
import com.demo.android.activity.TableLayoutActivity;
import com.demo.android.activity.TextInputLayoutActivity;
import com.demo.android.activity.ThressDActivity;
import com.demo.android.activity.ViewActivity;
import com.demo.android.anim.ViewAnimActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void jumpToActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void onClickTableLayout(View view) {
        jumpToActivity(TableLayoutActivity.class);
    }

    public void onClickEditManagedByTextInputLayout(View view) {
        jumpToActivity(TextInputLayoutActivity.class);
    }

    public void onClickGridLayout(View view) {
        jumpToActivity(GridLayoutActivity.class);
    }

    public void onClickRelativeLayout(View view) {
        jumpToActivity(RelativeLayoutActivity.class);
    }

    public void onClickMenuActivity(View view) {
        jumpToActivity(MenuActivity.class);
    }

    public void onClickViewActivity(View view) {
        jumpToActivity(ViewActivity.class);
    }

    public void onClickListViewActivity(View view) {
        jumpToActivity(ListViewActivity.class);
    }

    public void onClickLDynamicReceiver(View view) {
        jumpToActivity(DynamicReceiverActivity.class);
    }

    public void onClickLAnim(View view) {
        jumpToActivity(ViewAnimActivity.class);
    }

    public void onClick3D(View view) {
        jumpToActivity(ThressDActivity.class);
    }

    public void onClickAnim(View view) {
        jumpToActivity(AnimActivity.class);
    }

    public void onClickJumpToCustomView(View view) {
        jumpToActivity(CustomViewActivity.class);
    }

    public void onClickActivityLaunchMode(View view) {
        jumpToActivity(LaunchModeActivity.class);
    }
}