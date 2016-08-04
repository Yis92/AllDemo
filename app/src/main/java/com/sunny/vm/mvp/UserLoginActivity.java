package com.sunny.vm.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sunny.R;
import com.sunny.vm.mvp.bean.User;
import com.sunny.vm.mvp.presenter.UserLoginPresenter;
import com.sunny.vm.mvp.view.IUserLoginView;

import cn.trinea.android.common.util.ToastUtils;

/**
 * Created by toreal on 2016/7/14.
 */
public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        initViews();
    }

    private void initViews() {
        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnClear = (Button) findViewById(R.id.btn_clear);

        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        ToastUtils.show(this,"showLoading");
    }

    @Override
    public void hideLoading() {
        ToastUtils.show(this,"hideLoading");
    }

    @Override
    public void toMainActivity(User user) {
        ToastUtils.show(this,"toMainActivity");
    }

    @Override
    public void showFailedError() {
        ToastUtils.show(this,"showFailedError");
    }
}
