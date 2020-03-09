package com.algorithm.patterns.factory;
/**
 * Created by GD on 2018/4/20.
 */

/**
 * @Description TODO
 * @Author GD
 * @Date 2018/4/20 23:16
 * @Version 1.0V
 */
public class Royce implements Car {
    public void drive() {
        System.out.println("Royce Drive");
    }

    public void stop() {
        System.out.println("Royce stop");
    }

    public void repair() {
        System.out.println("Royce repair");
    }
}
