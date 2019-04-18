package com.algorithm.question;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/18
 * @Description: 求数组的中位数。
 * 数组由一个升序数组翻转形成，如1 2 3 4 5 6 7可以从5处翻转，
 * 形成5 6 7 1 2 3 4，求5 6 7 1 2 3 4的中位数。
 * 思路：
 * 二分查找。
 * 如果中间那个数大于第一个数，则中位数在前半部，可能包含中间那个数。
 * 如果中间那个数小于第一个数，则在后半部，不包含mid
 * 再判断
 */
public class MedianInRotateArray {

    public double getMedian(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = low + (high - low) / 2;
        int len = arr.length;
        if (len % 2 == 1) {
            if (arr[mid] > arr[low] && arr[mid] < arr[high]) {
                return arr[mid];
            } else if (arr[mid] > arr[low]) {
                int count = 0;
                for (int i = mid + 1; i <= high; i++) {
                    if (arr[mid] < arr[i]) {
                        count++;
                    }
                }
                return arr[count];
            } else {
                int count = 0;
                for (int i = 0; i < mid; i++) {
                    if (arr[mid] < arr[i]) {
                        count++;
                    }
                }
                return arr[mid + count];
            }
        } else {
            double median = (double) (arr[mid] + arr[mid + 1]) / 2;
            if (median > arr[low] && median < arr[high]) {
                return median;
            } else if (median > arr[low]) {
                int count = 0;
                for (int i = mid + 1; i <= high; i++) {
                    if (arr[mid] < arr[i]) {
                        count++;
                    }
                }
                return (double) (arr[count] + arr[count + 1]) / 2;
            } else {
                int count = 0;
                for (int i = 0; i < mid; i++) {
                    if (arr[mid] < arr[i]) {
                        count++;
                    }
                }
                return (double) (arr[mid + count] + arr[mid + count + 1]) / 2;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {2, 3, 4, 5, 6, 7, 1};
        int[] arr3 = {3, 4, 5, 6, 7, 1, 2};
        int[] arr4 = {4, 5, 6, 7, 1, 2, 3};
        int[] arr5 = {5, 6, 7, 1, 2, 3, 4};
        int[] arr6 = {6, 7, 1, 2, 3, 4, 5};
        int[] arr7 = {7, 1, 2, 3, 4, 5, 6};
        int[] arr8 = {7, 8, 1, 2, 3, 4, 5, 6};
        int[] arr9 = {1, 2, 3, 4, 5, 6, 7, 8,};
        int[] arr10 = {6, 7, 8, 1, 2, 3, 4, 5};
        int[] arr11 = {5, 6, 7, 8, 1, 2, 3, 4};
        MedianInRotateArray obj = new MedianInRotateArray();
        double median = obj.getMedian(arr11);
        System.out.println(median);
    }

}
