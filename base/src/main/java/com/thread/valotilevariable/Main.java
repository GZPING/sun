package com.thread.valotilevariable;

/**
 * Created by GD on 2018/9/1.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

import com.thread.sycmethod.MyThreadB;

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/9/1 22:58
 * @Since 1.0V
 */

public class Main {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        MyThread[] myThreads = new MyThread[100];
        for (int i = 0; i <100; i++) {
            myThreads[i] = new MyThread(myObject,i + "");
        }
        for (int i = 0; i < 100; i++) {
            myThreads[i].start();
        }
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myObject.getI());
    }



}
