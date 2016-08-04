package com.sunny.vm;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sunny.R;
import com.sunny.base.BaseActivity;

/**
 * Created by toreal on 2016/6/14.
 */
public class LoginDesignActivity extends BaseActivity {

    private TextInputLayout tilUsername;
    private TextInputLayout tilPassword;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_login_design);
    }

    @Override
    public void initBoot() {

    }

    @Override
    public void initViews() {
        tilUsername = findView(R.id.til_username);
        tilPassword = findView(R.id.til_password);
        etUsername = findView(R.id.et_username);
        etPassword = findView(R.id.et_password);
        btnSubmit = findView(R.id.btn_submit);
    }

    @Override
    public void initData(Intent intent) {
        tilUsername.setHint("手机号码");
    }

    @Override
    public void initEvents() {
        //提交
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = etPassword.length();
                int length2 = etUsername.length();
                //
                if (length<6) {
                    tilPassword.setError("密码长度不能小于６");
                }else{
                    tilPassword.setErrorEnabled(false);
                }

                //
                if (length2<6) {
                    tilUsername.setError("密码长度不能小于６");
                }else{
                    tilUsername.setErrorEnabled(false);
                }
            }
        });
        //
        etUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public Class<?> getClazz() {
        return LoginDesignActivity.class;
    }
}
