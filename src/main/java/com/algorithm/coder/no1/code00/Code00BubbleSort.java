package com.algorithm.coder.no1.code00;

/**
 * @Author: jiangjiabin
 * @Description: 冒泡排序: 每一次循环最大的数都到最后了
 * O(N^2)
 * @Date: Create in 15:22 2019/2/21
 */
public class Code00BubbleSort {

    private static void bubbleSort1(int[] arr) {
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

    //优化：当完全有序的时候，时间复杂度就是O(n)
    private static void bubbleSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            boolean sorted = true;
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    Common.swap(arr, i, i + 1);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    //优化：当局部有序时, 记录最后1次交换的位置
    private static void bubbleSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            int sortIndex = 0;
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    Common.swap(arr, i, i + 1);
                    sortIndex = i + 1;
                }
            }
            end = sortIndex;
        }
    }

    public static void main(String[] args) {
        int testTime = 50;//测试50万次
        int maxSize = 20;
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


    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            int lastIndex = 0;
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    Common.swap(arr, i, i+ 1);
                    lastIndex = i + 1;
                }
            }
            end = lastIndex;
        }
    }
}
