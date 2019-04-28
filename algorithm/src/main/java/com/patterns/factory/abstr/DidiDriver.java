package com.patterns.factory.abstr;

/**
 * Created by GD on 2018/4/20.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/20 23:45
 * @Version 1.0V
 */

public class DidiDriver implements Driver{
    public void driver() {
        System.out.println("Didi Driver driver");
    }

    public void leave() {
        System.out.println("Didi Driver leave");
    }
}
