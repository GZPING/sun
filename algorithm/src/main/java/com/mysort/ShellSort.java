package com.mysort;

/**
 * Created by GD on 2019/4/10.
 */

/**
 *  空间复杂度：
 *  时间复杂度：
 * @Description TODO
 * @Author GD
 * @Date 2019/4/10 21:44
 * @Version 1.0V
 */

public class ShellSort implements Sort {
    @Override
    public void sort(int[] a) {
        for (int grap = a.length/2; grap > 0; grap = grap / 2) {
            for (int i = grap; i < a.length; i++) {
                int index = i - grap;
                int temp = a[i];
                while (index >= 0 && a[index] > temp){
                    a[index + grap] = a[index];
                    index = index - grap;
                }
                a[index + grap] = temp;
            }
        }
    }
}
