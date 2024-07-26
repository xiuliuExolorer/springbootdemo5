package org.example.springbootdemo5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {

    @Test
    public void testQuickSort(){
        int[] arrs = {2,3,1};
        quickSort(arrs,0,arrs.length-1);
        for (int num : arrs) {
            System.out.print(num + " ");
        }
//        System.out.println(Arrays.toString(arrs));
    }

    void quickSort(int[] arrs, int low, int high) {
        if (low > high) {
            return;
        }
        int originalLow = low;
        int originalHigh = high;
        //基准
        int temp = low ;
        while (low<high){
            while (low <= high&& arrs[temp]>=arrs[low]) {
                low++;
            }
            while (low <= high&& arrs[temp]<=arrs[high]) {
                high--;
            }
            if(low<high){
                swap(arrs,low,high);
            }
        }
        //基准元素归位
        swap(arrs,temp,high);
        //进入递归
        quickSort(arrs, originalLow, high-1);
        quickSort(arrs, high+1, originalHigh);
    }

    void swap(int [] arr,int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
