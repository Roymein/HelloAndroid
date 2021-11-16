package com.demo.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.android.customview.MusicPlayerActivity;
import com.demo.android.customview.CustomViewActivity;
import com.demo.android.broadcast.DynamicReceiverActivity;
import com.demo.android.view.layoutview.GridLayoutActivity;
import com.demo.android.activity.launchmode.LaunchModeActivity;
import com.demo.android.view.ListViewActivity;
import com.demo.android.view.MenuActivity;
import com.demo.android.view.layoutview.RelativeLayoutActivity;
import com.demo.android.view.layoutview.TableLayoutActivity;
import com.demo.android.view.layoutview.TextInputLayoutActivity;
import com.demo.android.customview.ThressDActivity;
import com.demo.android.view.DialogActivity;
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

    public void onClickJumpTest(View view) {
        jumpToActivity(TestActivity.class);
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
        jumpToActivity(DialogActivity.class);
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

    public void onClickPlayer(View view) {
        jumpToActivity(MusicPlayerActivity.class);
    }

    public void onClickJumpToCustomView(View view) {
        jumpToActivity(CustomViewActivity.class);
    }

    public void onClickActivityLaunchMode(View view) {
        jumpToActivity(LaunchModeActivity.class);
    }
}