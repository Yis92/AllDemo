package com.sunny.vm.dagger2;


import com.sunny.vm.dagger2.bean.Apple;
import com.sunny.vm.dagger2.bean.Banner;
import com.sunny.vm.dagger2.bean.Fruit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by toreal on 2016/7/21.
 */
@Module//1  注明本类属于Module
public class FruitModule {

    @Named("typeA")
    @Provides  //2 注明该方法是用来提供依赖对象的特殊方法
    public Fruit provideFruit(){
        return new Apple(12, 20);
    }

    @Named("typeB")
    @Provides  //2 注明该方法是用来提供依赖对象的特殊方法
    public Fruit provideBanner(){
        return new Banner(12, 20);
    }

}
