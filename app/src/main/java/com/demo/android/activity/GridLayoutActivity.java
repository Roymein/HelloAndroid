package com.demo.android.activity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridLayout;

import com.demo.android.R;
import com.demo.lib.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class GridLayoutActivity extends BaseActivity {
    private static final String TAG = "GridLayoutActivity";

    private GridLayout mGridLayout;
    private AutoCompleteTextView mTvResult;
    private Button mBtnClear;
    private String[] mKeyName = new String[]{
            "7", "8", "9", "/",
            "4", "5", "6", "x",
            "1", "2", "3", "-",
            ".", "0", "=", "+"
    };

    private List<String> mKeySymbol = new ArrayList<>();
    private String mExpression = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_grid_layoutctivity);
    }

    @Override
    protected void init() {
        mGridLayout = findViewById(R.id.gl_calculator);
        mTvResult = findViewById(R.id.tv_calculate_result);
        mBtnClear = findViewById(R.id.btn_clear);

        for (int i = 0; i < mKeyName.length; i++) {
            Button btnKey = new Button(this);
            btnKey.setId(i);
            btnKey.setText(mKeyName[i]);
            btnKey.setAllCaps(false);
            btnKey.setTextSize(getResources().getDimension(R.dimen.text_size));
            btnKey.setOnClickListener(v -> {
                String symbol = btnKey.getText().toString();
                mExpression += symbol;
                mTvResult.setText(mExpression);


                mKeySymbol.add(symbol);
                mExpression.split("");

                boolean calculate = btnKey.getText().equals("=");

            });
            GridLayout.Spec row = GridLayout.spec(i / 4 + 2);
            GridLayout.Spec column = GridLayout.spec(i % 4);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(row, column);
            mGridLayout.addView(btnKey, layoutParams);
        }

        mBtnClear.setOnClickListener(v -> {
            mTvResult.setText("");
            mExpression = "";
            mKeySymbol.clear();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mExpression = "";
        mKeySymbol.clear();
    }

}