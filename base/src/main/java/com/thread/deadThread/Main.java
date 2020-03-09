package com.thread.deadThread;

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

public class Main {
    public static void main(String[] args) {
        (new MyThread(true)).start();
        (new MyThread(false)).start();
    }



}
