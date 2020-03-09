package com.lambda;

/**
 * Created by GD on 2019/8/22.
 */

import org.junit.Test;

import java.util.Optional;

/**
 *
 * @Description Opertion
 * @Author GD
 * @Date 2019/8/22 22:02
 * @Version 1.0V
 */

public class OptionalS {

    @Test
    public void test(){
        Integer val = null;
        // ofNullable  设置值，orElse 如果为空，则选else 值
        val = Optional.ofNullable(val).orElse(10);
        System.out.println("value 1 : " + val);
    }

    @Test
    public void test1(){
        Integer val = null;
        // ofNullable  设置值，orElse 如果为空，则选else 值
        val = Optional.ofNullable(val).orElse(10);
        System.out.println("value 1 : " + val);
    }

    @Test
    public void test12(){
        Optional<Integer> optional = Optional.empty();
        optional.orElse(10);
        Integer val = optional.get();
        System.out.println("value 1 : " + val);
    }


    public static void main(String[] args) {
        Integer val;
        // of 设置Optional value 值，如果of 传入为null ，则报错
        Optional<Integer> optional = Optional.of(10);
        // get  获取value 值
        try {
            optional = Optional.of(null);
        } catch (Exception e) {
            System.out.println("ex");
        }
        val = optional.get();
        System.out.println("value 1 : " + val);

    }
}
