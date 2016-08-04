package com.sunny.vm.mvp.biz.impl;

import com.sunny.vm.mvp.bean.User;
import com.sunny.vm.mvp.biz.IUserBiz;
import com.sunny.vm.mvp.biz.OnLoginListener;

/**
 * 接口交互的实现
 * Created by toreal on 2016/7/14.
 */
public class UserBizImpl implements IUserBiz {

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("zhy".equals(username) && "123".equals(password))
                {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
