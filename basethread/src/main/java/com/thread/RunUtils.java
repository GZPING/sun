package com.thread;

/**
 * @Description
 * @Author GD
 * @Date 2020/1/8 21:55
 */
public class RunUtils {

    private static int sum(int num,int count){
        int result = 0;
        for (int i = 0; i < count; i++) {
            result += num;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static int count(int num,int count){
        int result = 0;
        for (int i = 0; i < count; i++) {
            result += num;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
