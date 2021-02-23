package com.algorithm.coder.no1.code00;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/12
 * @Description: 希尔排序。是插入排序的改进版。非稳定
 * 设待排序元素序列有n个元素，首先取一个整数increment（小于n）作为间隔
 * 将全部元素分为increment个子序列，所有距离为increment的元素放在同一个子序列中，
 * 在每一个子序列中分别实行直接插入排序。然后缩小间隔increment，
 * 重复上述子序列划分和排序工作。直到最后取increment=1，将所有元素放在同一个子序列中排序为止。
 */
public class Code12ShellSort {

    public static void shellSort(int[] arr) {
        //增量gap, 并逐渐缩小增量
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            //从第gap个元素，逐渐对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                //j - gap 代表与他同组的元素
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && arr[j - gap] > temp) {
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Common.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Common.copyArray(arr1);
            shellSort(arr1);
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
        shellSort(arr);
        Common.printArray(arr);
    }

}
