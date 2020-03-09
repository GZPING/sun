package com.juc.lock.reentrantlock;

/**
 * Created by GD on 2018/9/1.
 * Blog: https://blog.csdn.net/SaketGD
 * GitHub: https://github.com/GZPING
 */

/**
 * @Description
 * @Author GD
 * @Date 2018/9/1 23:07
 * @Since 1.0V
 */

public class MyObject {

    private int i = 0;

    public Object lock = new Object();
    public Object lock2 = new Object();

    public void Method1() {
        synchronized (this){
            try {
                for (int j = 0; j < 100000; j++) {
                    i++;
                }
                Thread.sleep(2000);
                System.out.println("begin thread threadName = "
                        + Thread.currentThread().getName() + "i=" + i);
            }catch (Exception e){

            }
        }

    }

    public int getI() {
        return i;
    }

    /**
     *
     验证sychonized 锁住的对象方法，其他线程将无法进入该方法中
     * @param userName
     */
     public void methodA(String userName) {
        int num = 0;
         synchronized(this){
             try {
                 if ("a".equals(userName)) {
                     num = 100;
                     System.out.println(num);
                     Thread.sleep(5000);
                 } else if ("b".equals(userName)) {
                     num = 200;
                     System.out.println(num);
                 }
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }

    /*
     * 如果代码A中使用的是模块锁，但是如果要执行一个方法锁的话，还是需要获取
     * 对象锁的，将需要代码块锁释放后才能执行
     */
    synchronized public void methodB(){
        System.out.println("methodB");
    }

    /**
     * 当执行代码块的时候，将不会对对象上锁，其他使用代码块锁将依然可以执行。
     */
    public void methodC(){
        synchronized (this){
            System.out.println("methodC");
        }
    }

    /**
     * 验证死锁方法
     */
    public void methodD(String userName){
        int num = 0;
            try {
                if ("a".equals(userName)) {
                    synchronized(lock) {
                        num = 100;
                        System.out.println("userA lock1");
                        Thread.sleep(5000);
                        synchronized (lock2){
                            System.out.println("userA lock2");
                        }
                    }
                } else if ("b".equals(userName)) {
                    synchronized(lock2) {
                        num = 200;
                        System.out.println("userB lock1");
                        Thread.sleep(5000);
                        synchronized (lock){
                            System.out.println("userB lock2");
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
