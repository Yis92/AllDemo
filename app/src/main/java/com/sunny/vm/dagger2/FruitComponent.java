package com.sunny.vm.dagger2;


import dagger.Component;

/**
 * Created by toreal on 2016/7/21.
 */
@Component(modules={FruitModule.class}) //3 指明Component在哪些Module中查找依赖
public interface FruitComponent { //4 接口，自动生成实现

    void inject(DaggerActivity daggerActivity);//5  注入方法，在Container中调用
}
