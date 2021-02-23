package com.algorithm.coder.no1.code00;

/**
 * @Author: jiangjiabin
 * @Description: 快排（优化后的）：拿数组的最后一个数作为num，用于比较，注：这个数不参与比较（不动）
 * 前边是小于num的，后面是大于num的，中间是等于num的
 * 相对于经典快排更快，因为经典快排只确定了中间一个数是等于num
 * 时间复杂度和数据状况有关，如果是已经排好序的，就会变成O(N^2)
 * 用随机数做num，时间复杂度就是数学期望算出来的：O(N*logN) (随机快排)，额外空间复杂度是O(logN)
 * @Date: Create in 11:52 2019/2/22
 */
public class Code06QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
//            Common.swap(arr, l + (int) (Math.random() * (r - l + 1)), r);//随机选一个数和最后一个数交换
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                Common.swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                Common.swap(arr, --more, l);
            } else {
                l++;
            }
        }
        Common.swap(arr, more, r);//交换最后一个数
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int testTime = 5;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Common.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Common.copyArray(arr1);
            quickSort(arr1);
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
        quickSort(arr);
        Common.printArray(arr);

        quickSort(new int[]{3,1,2,8,7,3,2});
    }

}
