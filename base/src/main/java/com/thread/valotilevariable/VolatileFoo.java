package com.thread.valotilevariable;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 *
 * volatile 关键字只能修饰类变量和实例变量，对于方法参数，局部变量，实例常量，类常量，都是不可修饰
 *
 * 例子1 ：
 *  static int initValue = 1;
 *  result:
 *  we will update initValue1 ====1
 *  localValue is not equal initValue1 ==== 2
 *  we will update initValue2 ====2
 *  we will update initValue3 ====3
 *  we will update initValue4 ====4
 *  进入死循环
 *
 * 例子2 ：
 *  volatile static int initValue = 1;
 *  result:
 *  we will update initValue1 ====1
 *  localValue is not equal initValue1 ==== 2
 *  we will update initValue2 ====2
 *  localValue is not equal initValue2 ==== 3
 *  we will update initValue3 ====3
 *  localValue is not equal initValue3 ==== 4
 *  we will update initValue4 ====4
 *  localValue is not equal initValue4 ==== 5
 * @author : GD
 * @date :2020/3/16 : 21:50
 */
public class VolatileFoo {

    final static int MAX = 5;

    static int initValue = 1;

    public static void main(String[] args) {
        // 当localValue 和 initValue 不相等是，打印日志，理论上，localValue 都会等于localValue
        new Thread(()->{
            int localValue = initValue;
            while (localValue < MAX){
                if(localValue != initValue){
                    System.out.println(" localValue is not equal initValue" + localValue +  " ==== " + initValue);
                    localValue = initValue;
                }
            }
        },"reader").start();

        new Thread(()->{
            int localValue = initValue;
            while (localValue < MAX){
                System.out.println(" we will update initValue" + (localValue++) +  " ====" + initValue);
                initValue = localValue ;
                try {
                    // 线程休息2秒钟
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"update").start();
    }
}
