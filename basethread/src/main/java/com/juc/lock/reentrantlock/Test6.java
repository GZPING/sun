package com.juc.lock.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author GD
 * @Date 2020/1/8 23:20
 */
public class Test6 {
    final Lock lock = new ReentrantLock();
    final java.util.concurrent.locks.Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    private static Test6 test = new Test6();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            //防止虚假唤醒，Condition的await调用一般会放在一个循环判断中
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length)
                putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length)
                takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }





    public static void main(String[] args) throws InterruptedException {
        Test6 test6 = new Test6();
        for (int i = 0; i < 100; i++) {
            test6.put(new Object());
        }
        test6.put(new Object());
        test6.put(new Object());
        System.out.println(test6.take());
        System.out.println(test6.take());
    }
}
