package com.patterns.builder;

/*
  Created by GD on 2018/4/22.
  Blog: https://blog.csdn.net/SaketGD
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/22 17:25
 * @Since 1.0V
 */

public class ChickenBurger extends Burger {
    public String name() {
        return "Chicken Burger";
    }

    public float price() {
        return 50.5f;
    }
}
