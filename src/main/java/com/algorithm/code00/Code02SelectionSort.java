package com.algorithm.code00;

/**
 * @Author: jiangjiabin
 * @Description: 选择排序: 比较arr[0]和arr[1~N]的数, 将最小的放到arr[0]
 * 然后是比较arr[1]和arr[2~N]...
 * O(N^2)
 * @Date: Create in 15:45 2019/2/21
 */
public class Code02SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            Common.swap(arr, i, minIndex);
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
            selectionSort(arr1);
            Common.comparator(arr2);
            if (!Common.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = Common.generateRandomArray(maxSize, maxValue);
        Common.printArray(arr);
        selectionSort(arr);
        Common.printArray(arr);
    }
}
