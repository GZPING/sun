package com.algorithm.MySearch;

/**
 * Created by GD on 2019/4/10.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/4/10 23:47
 * @Version 1.0V
 */

public class SequenceSearch implements Search{


    @Override
    public int search(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            if(a[i] == value){
                return i;
            }
        }
        return -1;
    }
}
