package com.thread.valotilevariable;

/**
 * Created by GD on 2018/9/1.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 * <p>
 * 可重入锁表示已经获取到的锁，如果需要再次获取内部锁，将可以继续获取到锁，不需要重新
 * 获取，可重入说也支持在父子类继承环境中。
 */

/**
 * 可重入锁表示已经获取到的锁，如果需要再次获取内部锁，将可以继续获取到锁，不需要重新
 * 获取，可重入说也支持在父子类继承环境中。
 */

/**
 * @Description
 * @Author GD
 * @Date 2018/9/1 23:07
 * @Since 1.0V
 */

public class MyObject {

    private int i = 0;

    //volatile public static int count = 0;

     public void Method1() {

        for (int j = 0; j < 10000; j++) {
            i++;
        }
        System.out.println("begin thread threadName = "
                + Thread.currentThread().getName() + "count=" + i);
    }

    public int getI() {
        return i;
    }

}
