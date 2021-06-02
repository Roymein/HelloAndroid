package com.demo.android.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.demo.android.R;

public class ListViewActivity extends AppCompatActivity {
    private String[] data = {"Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple",
            "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        hideActionBar();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, data);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null && actionBar.isShowing()) {
            actionBar.hide();
        }
    }


}