package com.thread.valotilevariable;

/**
 * Created by GD on 2018/9/1.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 *
 * @Description
 * @Author GD
 * @Date 2018/9/1 22:58
 * @Since 1.0V
 */

public class Main2 {
    public static void main(String[] args) {
        Object o = new Object();
        int count = 50;
        Thread[] arr = new Thread[count];
        for (int i = 0; i <count; i++) {
            arr[i] = new Thread1(o);
        }
        for (int i = 0; i < count; i++) {
            arr[i].start();
        }
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
