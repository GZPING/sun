package com.mysort;

/**
 * Created by GD on 2019/4/10.
 */

/**
 *
 * @Description TODO
 * @Author GD
 * @Date 2019/4/10 21:18
 * @Version 1.0V
 */

public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100);
        }
       // Sort sort = new QuickSort();
        //Sort sort = new BubbleSort();
        // Sort sort = new InsertSort();
        Sort sort = new ShellSort();
        long begin = System.currentTimeMillis();
        sort.sort(arr);
        System.out.println(System.currentTimeMillis() - begin);
        for (int i=0;i<arr.length;i++){
            if(i % 25 == 0)
                System.out.println();
            System.out.print(arr[i] + "  ");
        }
    }
}
