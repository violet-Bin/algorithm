package com.algorithm.coder.no1.code00;

/**
 * @Author: jiangjiabin
 * @Description:  归并排序（递归）：两边分别排好, 再合并
 * O(N*logN)
 * @Date: Create in 16:54 2019/2/21
 */
public class Code03MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);//L和R中间的位置
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Common.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Common.copyArray(arr1);
            mergeSort(arr1);
            Common.comparator(arr2);
            if (!Common.isEqual(arr1, arr2)) {
                succeed = false;
                Common.printArray(arr1);
                Common.printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = Common.generateRandomArray(maxSize, maxValue);
        Common.printArray(arr);
        mergeSort(arr);
        Common.printArray(arr);
    }


}
