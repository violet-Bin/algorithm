package com.algorithm.swordoffer;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 解：
 * 是排序好的：左右加逼
 */
public class Code40FindNumbersWithSum {

    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return list;
    }
}
