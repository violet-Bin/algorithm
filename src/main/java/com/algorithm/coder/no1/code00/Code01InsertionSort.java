package com.algorithm.coder.no1.code00;

/**
 * @Author: jiangjiabin
 * @Description: 插入排序: 就像插入新牌
 * 从第二个数开始，将这个数依次往前比较，判断能否交换
 * O(N^2)
 * @Date: Create in 15:42 2019/2/21
 */
public class Code01InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                Common.swap(arr, j, j + 1);
            }
        }
    }

    /**
     * 实现为稳定的
     * @param arr
     */
    public static void insertionSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    Common.swap(arr, j, j + 1);
                } else if (arr[j] == arr[j + 1]) {
                    j--;
                }
            }
        }
    }



    public static void main(String[] args) {
        int testTime = 500000;//测试50万次
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Common.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Common.copyArray(arr1);
            insertionSort2(arr1);
            Common.comparator(arr2);
            if (!Common.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = Common.generateRandomArray(maxSize, maxValue);
        Common.printArray(arr);
        insertionSort2(arr);
        Common.printArray(arr);

//        int testTime = 500000;//测试50万次
//        int maxSize = 10;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = Common.generateRandomArray(maxSize, maxValue);
//            int[] arr2 = Common.copyArray(arr1);
//            insertionSort(arr1);
//            Common.comparator(arr2);
//            if (!Common.isEqual(arr1, arr2)) {
//                succeed = false;
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = Common.generateRandomArray(maxSize, maxValue);
//        Common.printArray(arr);
//        insertionSort(arr);
//        Common.printArray(arr);
    }

}
