package com.algorithm.patterns.builder;
/**
 * Created by GD on 2018/4/22.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2018/4/22 16:57
 * @Since 1.0V
 */
public interface Item {

     String name();

     Packing packing();

     float price();
}
