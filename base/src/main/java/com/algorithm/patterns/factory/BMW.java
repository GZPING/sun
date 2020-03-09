package com.algorithm.patterns.factory;
/**
 * Created by GD on 2018/4/20.
 *
 *
 */

/**
 * @Description TODO
 * @Author GD
 * @Date 2018/4/20 23:14
 * @Version 1.0V
 */
public class BMW implements Car {

    public void drive() {
        System.out.println("BMW Drive");
    }

    public void stop() {
        System.out.println("BMW Stop");
    }

    public void repair() {
        System.out.println("BMW repair");
    }
}
