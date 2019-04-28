package com.patterns.builder;
/**
 * Created by GD on 2018/4/22.
 * Blog: https://blog.csdn.net/SaketGD
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/22 17:08
 * @Since 1.0V
 */
public abstract class Burger implements Item {

    public Packing packing() {
        return new Wrapper();
    }

    public abstract float price();
}
