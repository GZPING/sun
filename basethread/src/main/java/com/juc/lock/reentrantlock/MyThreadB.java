package com.juc.lock.reentrantlock;

/**
 * Created by GD on 2018/9/2.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/9/2 11:43
 * @Since 1.0V
 */

public class MyThreadB extends Thread {

    private MyObject myObject;

    public MyThreadB(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        //myObject.methodB();
       // myObject.methodC();
        //
        System.out.println("thread B start");
        myObject.methodA("b");
    }
}
