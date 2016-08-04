package com.sunny.vm.mvp.biz;

/**
 * 与接口交互的方法
 * Created by toreal on 2016/7/14.
 */
public interface IUserBiz {

    public void login(String username, String password, OnLoginListener loginListener);

}
