package com.algorithm.patterns.prototype;

/**
 * Created by GD on 2018/4/21.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/21 21:01
 * @Version 1.0V
 */

public class Yasso extends Hero {

    public Yasso(Integer id) {
        super(id);
    }

    void kill() {
        System.out.println("yasso die");
    }
}
