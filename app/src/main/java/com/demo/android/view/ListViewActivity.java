package com.demo.android.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.demo.android.pojo.Fruit;
import com.demo.android.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private String[] data = {"Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple",
            "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple", "Apple"};

    private List<Fruit> mFruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        hideActionBar();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, data);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
//        initFruits();
//        FruitAdapter fruitAdapter = new FruitAdapter(this, R.layout.fruit_item_layout,mFruitList);
//        listView.setAdapter(fruitAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Fruit fruit = mFruitList.get(position);
            Toast.makeText(this, fruit.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    private void initFruits() {
        mFruitList.add(new Fruit("banana", R.mipmap.ic_launcher));
    }

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null && actionBar.isShowing()) {
            actionBar.hide();
        }
    }


}