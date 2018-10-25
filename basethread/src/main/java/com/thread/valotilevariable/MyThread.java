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
 * @Date 2018/9/1 22:59
 * @Since 1.0V
 */

public class MyThread extends Thread{

    private MyObject myObject;
    /**
     * volatile 每次从共享内存中读取变量，而不是私有变量
     */
    volatile public static int count = 0;
    public MyThread(MyObject myObject) {
        super();
        this.myObject = myObject;
    }
    public MyThread(MyObject myObject, String name) {
        super(name);
        this.myObject = myObject;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            count++;
        }
        System.out.println("begin thread threadName = "
                + Thread.currentThread().getName() + "count=" + count);
    }
}
