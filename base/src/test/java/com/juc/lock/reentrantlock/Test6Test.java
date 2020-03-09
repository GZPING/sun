package com.juc.lock.reentrantlock;


import org.junit.Test;

/**
 * @Description
 * @Author GD
 * @Date 2020/1/8 23:25
 */
public class Test6Test {

    private static Test6 test6 = new Test6();

    @Test
    public void put() throws InterruptedException {
        System.out.println("start");
        new Thread(() -> {
            for (int i = 0; i < 105; i++) {
                try {
                    test6.put(new Object());
                    System.out.print(test6.count +",");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println(test6.count);
                try {
                    System.out.println(test6.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(test6.count);
            }
        }).start();
    }
}
