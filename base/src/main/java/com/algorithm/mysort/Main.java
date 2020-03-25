package com.algorithm.mysort;

/**
 * @author : GD
 * @date :2020/3/25 : 23:27
 */
public class Main {

    public static void main(String[] args) {
        Sort sort = new QuickSort();
        int[] a = {1,2,53,23,4,234,123,534,324,432,26,43,1,5,6,23,41,66,74,23};
        sort.sort(a);
        sort.print(a);
    }
}
