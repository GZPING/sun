package com.mysort;

/**
 * Created by GD on 2019/4/10.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/4/10 21:16
 * @Version 1.0V
 */

public class BubbleSort implements Sort{


    @Override
    public void sort(int[] a) {
        // 冒泡排序要数组长度减一，因为比较后一个值了 j+1
        for (int i = 0; i < a.length -1 ; i++) {
            for (int j = 0; j < a.length -1 - i; j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a [j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
