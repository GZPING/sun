package com.patterns.factory;

/**
 * @Description TODO
 * @Author GD
 * @Date 2018/4/20 23:16
 * @Version 1.0V
 */
public class Benz implements Car {
    public void drive() {
        System.out.println("Benz Drive");
    }

    public void stop() {
        System.out.println("Benz stop");
    }

    public void repair() {
        System.out.println("Benz repair");
    }
}
