package com.algorithm.mysort;

/**
 * Created by GD on 2019/4/10.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/4/10 21:37
 * @Version 1.0V
 */

public class InsertSort implements Sort {
    @Override
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
          if(a[i - 1] > a[i]){ // 比后一位大，则要进行插入
              int temp  = a [i];
             // a[i] = a[i-1];// 第一次替换
              int index = i - 1;
              while(index >= 0 && temp < a [index]){
                  a[index + 1] = a[index];
                  index --;
              }
              a[index + 1] = temp;
          }
        }
    }
}
