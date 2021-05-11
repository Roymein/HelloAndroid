package com.demo.android.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.demo.android.R;
import com.demo.lib.activity.BaseActivity;
import com.google.android.material.textfield.TextInputLayout;

/**
 * 作为 EditText 的容器，为 EditText 生成浮动的 label。
 */
public class TextInputLayoutActivity extends BaseActivity {
    public static final String TAG = "TextInputLayoutActivity";

    private EditText mEditTextAccount;
    private EditText mEditTextPassword;

    private TextInputLayout mTextInputLayoutAccount;
    private TextInputLayout mTextInputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_text_input_layout);
    }

    @Override
    protected void init() {
        mEditTextAccount = findViewById(R.id.et_account);
        mEditTextPassword = findViewById(R.id.et_password);
        mTextInputLayoutAccount = findViewById(R.id.text_input_account);
        mTextInputLayoutPassword = findViewById(R.id.text_input_password);

        mTextInputLayoutAccount.setHint(getResources().getString(R.string.text_input_layout_account_hint));
        mTextInputLayoutPassword.setHint(getResources().getString(R.string.text_input_layout_password_hint));
    }

    public void login(View view) {
        String account = mEditTextAccount.getText().toString();
        String password = mEditTextPassword.getText().toString();

        checkEdit(account, mTextInputLayoutAccount, getResources().getString(R.string.text_input_layout_account_empty_hint));
        checkEdit(password, mTextInputLayoutPassword, getResources().getString(R.string.text_input_layout_password_empty_hint));
    }

    private void checkEdit(String edit, TextInputLayout inputLayout, String hint) {
        if (TextUtils.isEmpty(edit)) {
            inputLayout.setError(hint);
        } else {
            inputLayout.setErrorEnabled(false);
        }
    }
}