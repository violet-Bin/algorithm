package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 统计一个数字在排序数组中出现的次数。
 */
public class Code36GetNumberOfK {

    public int getNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0; i< array.length; i++) {
            if (array[i] == k) {
                count++;
            }
        }
        return count;
    }


}
