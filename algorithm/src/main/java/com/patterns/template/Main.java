package com.patterns.template;

/**
 * Created by GD on 2019/4/29.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/4/29 23:17
 * @Version 1.0V
 */

public class Main {
    public static void main(String[] args) {
        Game g = new Dnf();
        g.play();
        Game g2 = new Lol();
        g2.play();
    }
}
