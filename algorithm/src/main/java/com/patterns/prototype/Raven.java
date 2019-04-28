package com.patterns.prototype;

/**
 * Created by GD on 2018/4/21.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/21 21:00
 * @Version 1.0V
 */

public class Raven extends Hero {

    public Raven(Integer id) {
        super(id);
    }

    void kill() {
        System.out.println("Raven kill three");
    }
}
