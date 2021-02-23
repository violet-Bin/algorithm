package com.algorithm.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiangjiabin
 * @date: Create in 17:08 2021/2/20
 * @description: 两个升序的数组合并为一个  O(n)
 */
public class Main {

    public List merge(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < arr1.length || index2 < arr2.length) {
            if (index1 == arr1.length) {
                result.add(arr2[index2++]);
            } else if (index2 == arr1.length) {
                result.add(arr1[index1++]);
            } else if (arr1[index1] > arr2[index2]) {
                result.add(arr2[index2++]);
            } else {
                result.add(arr1[index1++]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 10, 12,13};
        int[] arr2 = {1, 3, 4, 7, 8, 9, 12,14};
        System.out.println(new Main().merge(arr1, arr2));
    }
}
