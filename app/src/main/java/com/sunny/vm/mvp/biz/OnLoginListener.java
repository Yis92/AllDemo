package com.sunny.vm.mvp.biz;

import com.sunny.vm.mvp.bean.User;

/**
 * 与接口交互成功与失败的监听
 * Created by toreal on 2016/7/14.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
