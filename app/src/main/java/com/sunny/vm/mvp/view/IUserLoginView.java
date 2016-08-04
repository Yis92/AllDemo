package com.sunny.vm.mvp.view;

import com.sunny.vm.mvp.bean.User;

/**
 * 界面交互操作
 * Created by toreal on 2016/7/14.
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
