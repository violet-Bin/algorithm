package com.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Code28GetLeastNumbers {

    public ArrayList<Integer> getLeastNumbersSolution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = input.length;
        if (len < k) {
            return list;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }


}
