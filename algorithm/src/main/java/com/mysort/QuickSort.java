package com.mysort;

/**
 * Created by GD on 2019/3/19.
 */

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Description 快排
 * 思路：找到基准点，将大于基准值的放右边，小于基准值的放左边，再找左边的基准点，再找右边的基准点，如此循环，直到只有一个元素
 *
 * @Author GD
 * @Date 2019/3/19 22:38
 * @Version 1.0V
 */

public class QuickSort {

    public static int position(int[] arr,int left,int right){
        // 存储基准值
        int key = arr[left];
        while(left<right){
            //判断右侧数据是否大于基准值，大于则继续保留，小于，则替换，再找左边
            while(arr[right]>=key && left<right){
                right--;
            }
            arr[left]=arr[right];
            while (arr[left]<=key && left<right){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }

    public static int[] sort(int[] arr,int left,int right){
        if(left>=right){
            return arr;
        }
        int index = position(arr,left,right);
        sort(arr,left,index-1);
        sort(arr,index+1,right);
        return arr;



    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,1,10,2,5,2,56,0};
        QuickSort.sort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "  ");
        }

    }

}
