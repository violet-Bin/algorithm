package com.algorithm.code00;

/**
 * @Author: jiangjiabin
 * @Description: 冒泡排序: 每一次循环最大的数都到最后了
 * O(N^2)
 * @Date: Create in 15:22 2019/2/21
 */
public class Code00BubbleSort {

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    Common.swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;//测试50万次
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Common.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Common.copyArray(arr1);
            bubbleSort(arr1);
            Common.comparator(arr2);
            if (!Common.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = Common.generateRandomArray(maxSize, maxValue);
        Common.printArray(arr);
        bubbleSort(arr);
        Common.printArray(arr);
    }
}
