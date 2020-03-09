package com.thread.reentrantlock;

/**
 * Created by GD on 2019/5/13.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/5/13 23:22
 * @Version 1.0V
 */

public class Main {

    public static void main(String[] args) {
        int count = 50;
        Thread[] arr = new Thread[count];
        for (int i = 0; i <count; i++) {
            arr[i] = new Thread1();
        }
        for (int i = 0; i < count; i++) {
            arr[i].start();
        }
    }
}
