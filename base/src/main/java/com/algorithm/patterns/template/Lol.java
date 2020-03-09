package com.algorithm.patterns.template;

/**
 * Created by GD on 2019/4/29.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/4/29 23:15
 * @Version 1.0V
 */

public class Lol extends Game {
    @Override
    protected void gameing() {
        System.out.println("LOL Gaming");
    }

    @Override
    protected void over() {
        System.out.println("LOL over");
    }

    @Override
    protected void init() {
        System.out.println("LOL init");
    }
}
