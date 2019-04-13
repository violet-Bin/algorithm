package com.algorithm.coder.no1.code00;

/**
 * @Author: jiangjiabin
 * @Description: 堆是满二叉树
 * 完全二叉树包括满二叉树， 除了满二叉树以外，如果子节点从左往右是补全了的，也是完全二叉树
 * 堆可以用数组表示：i的左子节点是 2*i+1   右子节点是 2*i+2     越界了则表示没有    父节点是 (i-1)/2
 * 大根堆：在完全二叉树中，任何一棵子树的最大值都是这棵子树的头部
 * 小根堆：在完全二叉树中，任何一棵子树的最小值都是这棵子树的头部
 * 弹出堆顶：将最后一个元素和堆顶交换，将堆的界限缩小1，再进行一个heapify
 * 堆排序时间复杂度：o(N*logN), 额外空间复杂度O(1)
 * @Date: Create in 12:50 2019/2/22
 */
public class Code07HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);//生成大根堆
        }
        int size = arr.length;
        //先交换最后一个元素和堆顶元素（堆顶元素是最大的），再缩小堆的范围
        Common.swap(arr, 0, --size);
        while (size > 0) {
            //下沉堆顶元素
            heapify(arr, 0, size);
            Common.swap(arr, 0, --size);
        }
    }

    //生成大根堆   O(N)
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Common.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //如果堆顶的数变了，如果是小于子节点，将他下沉
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        //只要不越界
        while (left < size) {
            //取左子节点和右子节点最大的数  右子节点：left + 1
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //再和index的数比较
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            Common.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Common.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Common.copyArray(arr1);
            heapSort(arr1);
            Common.comparator(arr2);
            if (!Common.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = Common.generateRandomArray(maxSize, maxValue);
        Common.printArray(arr);
        heapSort(arr);
        Common.printArray(arr);
    }

}
