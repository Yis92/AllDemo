package com.sunny.vm.dagger2.bean;

/**
 * Created by toreal on 2016/7/21.
 */
public class Banner implements Fruit{

    private int color;
    private int size;

    public Banner(int color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean eat() {
        return false;
    }
}
