package com.demo.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.demo.android.activity.DynamicReceiverActivity;
import com.demo.android.activity.GridLayoutActivity;
import com.demo.android.activity.ListViewActivity;
import com.demo.android.activity.MenuActivity;
import com.demo.android.activity.RelativeLayoutActivity;
import com.demo.android.activity.TableLayoutActivity;
import com.demo.android.activity.TextInputLayoutActivity;
import com.demo.android.activity.ViewActivity;
import com.demo.android.anim.ViewAnimActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void startActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void onClickTableLayout(View view) {
        startActivity(TableLayoutActivity.class);
    }

    public void onClickEditManagedByTextInputLayout(View view) {
        startActivity(TextInputLayoutActivity.class);
    }

    public void onClickGridLayout(View view) {
        startActivity(GridLayoutActivity.class);
    }

    public void onClickRelativeLayout(View view) {
        startActivity(RelativeLayoutActivity.class);
    }

    public void onClickMenuActivity(View view) {
        startActivity(MenuActivity.class);
    }

    public void onClickViewActivity(View view) {
        startActivity(ViewActivity.class);
    }

    public void onClickListViewActivity(View view) {
        startActivity(ListViewActivity.class);
    }

    public void onClickLDynamicReceiver(View view) {
        startActivity(DynamicReceiverActivity.class);
    }

    public void onClickLAnim(View view) {
        startActivity(ViewAnimActivity.class);
    }
}