package com.thread.sycmethod;

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
        MyObject myObject = new MyObject();
        //验证如果不存在sychonized 关键字，线程异步将可能会导致线程安全问题。例子中i值将不等于200000
//        MyThread myThread = new MyThread(myObject);
//        MyThread myThread2 = new MyThread(myObject);
        /*
        验证sychonized 锁住的对象方法，其他线程将无法进入该方法中
         */
        MyThread myThread = new MyThread(myObject,"a");
        MyThread myThread2 = new MyThread(myObject,"b");
        MyThreadB myThreadB = new MyThreadB(myObject);
        myThread.start();
        myThreadB.start();
       // myThread2.start();
        System.out.println("i = " + myObject.getI());
    }



}
