package com.algorithm.patterns.builder;

/**
 * Created by GD on 2018/4/22.
 * Blog: https://blog.csdn.net/SaketGD
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/22 17:31
 * @Since 1.0V
 */

public abstract class ColdDrink implements Item{

    public Packing packing() {
        return new Button();
    }

    public abstract float price();
}
