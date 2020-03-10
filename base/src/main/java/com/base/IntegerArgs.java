package com.base;

import java.lang.reflect.Field;

/**
 * @Author : GD
 * @Create :2019/8/14 : 11:12
 */
public class IntegerArgs {

    public static void main(String[] args) throws Exception{
        Integer a = 3;
        Integer b = 5;
        System.out.println("before swap: a="+ a + ",b=" + b);
        swap(a,b);
        System.out.println("after swap: a="+ a + ",b=" + b);
        Integer c = 3;
        System.out.println(c);
    }

    public static void swap(Integer a,Integer b) throws Exception {
        Field valueField = Integer.class.getDeclaredField("value");
        valueField.setAccessible(true);
        int tmpA = a.intValue();//3
        int tmpB = b.intValue();//5
        valueField.set(a,tmpB);

        //Integer.IntegerCache.cache 中的数组的值已经被改变
        valueField.set(b,tmpA);
    }


    public void temp() {
        double fansCount = 1000;
        String fans= "200";
        double areaFans1 = Double.valueOf(fans == null ? "0" : fans);
        System.out.println(areaFans1);
        System.out.println(areaFans1/fansCount);

        System.out.println(String.format("%.2f",0.99954*100));;
        System.out.println(String.format("%.2f",Double.valueOf("0.99954")*100));;
    }
}
