package com.thread.reentrantlock;

/**
 * Created by GD on 2019/5/13.
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/5/13 23:22
 * @Version 1.0V
 */

public class Thread1 extends Thread {

    // 必须静态的
    private static ReentrantLock look = new ReentrantLock();
    private static int count = 0;

    @Override
    public void run() {
        try {
            look.lock();
            for (int i = 0; i < 1000; i++) {
                count ++ ;
            }
        }finally {
            look.unlock();
        }
        System.out.println(Thread.currentThread().getName() + "   " + count);
    }
}
