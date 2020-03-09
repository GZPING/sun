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
 * @Date 2018/5/9 21:01
 * @Since 1.0V
 */

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setNumber(15);
        System.out.println("Second state change: 10");
        subject.setNumber(10);
    }
}
