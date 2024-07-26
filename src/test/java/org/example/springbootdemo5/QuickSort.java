package org.example.springbootdemo5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSort {
    
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1};
        QuickSort sorter = new QuickSort();
        sorter.quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }


    public int partition2(int [] arrs,int low, int high){
        int pivot = arrs[high];
        int i = low-1;
        int j = high;
        for (int k = low; k <j; k++) {
            if(pivot>arrs[k]){
                i++;
                swap(arrs,i,k);
            }
        }
        swap(arrs,high,i+1);
        return i+1;
    }

    @Test
    public void test2(){
        int[] arrs = {2,3,1};
        sort(arrs,0,arrs.length-1);
        for (int arr : arrs) {
            System.out.println(arr);
        }
    }

    public void sort(int [] arrs,int low,int high){
        if(low<high){
            int i = partition2(arrs, low, high);
            sort(arrs,low,i-1);
            sort(arrs,i+1,high);
        }
    }


    public <T,R> T test3(){
        T a = null;
        R b = null;
        return a;
    }
    

    public void  selectSort(int[] arrs){
        for (int i = 0; i < arrs.length-1; i++) {
            int temp = i;
            for (int j = i+1; j < arrs.length; j++) {
                if(arrs[i]>arrs[j]){
                    temp = j;
                }
            }
            if(temp!=i){
                swap(arrs,temp,i);
            }
        }
    }

    @Test
    public void testSelectSort(){
        int [] arrs = {2,3,1};
        selectSort(arrs);
        for (int arr : arrs) {
            System.out.print(" " +arr);
        }
    }

}