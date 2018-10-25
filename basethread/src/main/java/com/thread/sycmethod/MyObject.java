package com.thread.sycmethod;

/**
 * Created by GD on 2018/9/1.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
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

    synchronized public void Method1() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
        System.out.println("begin thread threadName = "
                + Thread.currentThread().getName() + "i=" + i);
    }

    public int getI() {
        return i;
    }

    /**
     *
     验证sychonized 锁住的对象方法，其他线程将无法进入该方法中
     * @param userName
     */
    synchronized public void methodA(String userName) {
        int num = 0;
        try {
            if ("a".equals(userName)) {
                num = 100;
                System.out.println(num);
                //methodB();
                Thread.sleep(5000);
            } else if ("b".equals(userName)) {
                num = 200;
                System.out.println(num);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * synchronized 如果修饰在方法上，是对整个对象进行上锁，在该对象中所有使用synchronized
     * 的方法将无法访问，但是如果不使用synchronized 的方法依然是可以方法的。所以synchronized
     * 上锁的代码只是锁住有synchronized 关键值的内容。
     */
    synchronized public void methodB(){
        System.out.println("methodB");
    }

}
