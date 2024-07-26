package org.example.springbootdemo5;

public class QuickSort2 {
    /**
     * 使用快速排序算法对数组进行排序
     * @param arr 待排序的数组
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序的递归实现
     * @param arr 待排序的数组
     * @param low 左边界
     * @param high 右边界
     */
    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high); // 获取基准值的索引
            sort(arr, low, pivot - 1); // 对基准值左侧的子数组进行排序
            sort(arr, pivot + 1, high); // 对基准值右侧的子数组进行排序
        }
    }

    /**
     * 快速排序的分区实现
     * @param arr 待排序的数组
     * @param low 左边界
     * @param high 右边界
     * @return 选择的基准值的索引
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // 选择第一个元素作为基准值
        int i = low;
        int j = high;

        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }

            while (i <= j && arr[j] >= pivot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j); // 将基准值放到正确的位置上

        return j;
    }

    /**
     * 交换数组中两个位置的元素
     * @param arr 数组
     * @param i 位置1
     * @param j 位置2
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1};
        quickSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
