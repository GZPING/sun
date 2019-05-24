package com.thread.valotilevariable;

/**
 * Created by GD on 2019/5/13.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/5/13 22:49
 * @Version 1.0V
 */

public class Thread1 extends Thread {

    public Thread1(Object o) {
        this.o = o;
    }

    // 不保证原子性
    private static int i = 0;

    private Object o;

    @Override
    public void run() {
        synchronized (o){
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }

        System.out.println(Thread.currentThread().getName() + " : "  + i);
    }

    public void outi(){
        System.out.println(i);
    }
}
