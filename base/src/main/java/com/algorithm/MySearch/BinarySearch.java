package com.algorithm.MySearch;

/**
 * Created by GD on 2019/4/10.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/4/10 23:49
 * @Version 1.0V
 */

public class BinarySearch implements Search {
    @Override
    public int search(int[] a, int value) {
         int begin = 0;
         int end = a.length - 1;
         int index = end / 2;
         while ((end - begin) >= 1){
             if(a[index] == value){
                 return index;
             }else if(a[index] > value){
                 end = index -1;
             }else {
                 begin = index + 1;
             }
             index = (begin + end)/2;
         }

        return -1;
    }
}
