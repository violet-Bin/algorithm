package com.algorithm.swordoffer;

import java.util.Arrays;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Code27MoreThanHalfNum {

    public int moreThanHalfNumSolution(int[] array) {
        int len = array.length;
        if (len < 1) {
            return 0;
        }
        Arrays.sort(array);
        int count = 0;
        int num = array[len / 2];
        for (int i = 0; i < len; i++){
            if (num == array[i]) {
                count++;
            }
        }
        if (count <= (len / 2)) {
            num = 0;
        }
        return num;
    }

}
