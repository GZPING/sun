package com.algorithm.patterns.observer;

/**
 * Created by GD on 2018/5/9.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/5/9 21:03
 * @Since 1.0V
 */

public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update(Integer data) {
        System.out.println("Hexa :" + Integer.toHexString(data));
    }
}
