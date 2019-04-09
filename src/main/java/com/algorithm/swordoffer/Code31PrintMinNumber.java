package com.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Code31PrintMinNumber {

    public String printMinNumber(int[] numbers) {
        int len = numbers.length;
        String str = "";
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            list.add(numbers[i]);
        }
        //升序，按字典顺序，ASCII码值
        list.sort((str1, str2) -> {
            String s1 = str1 + "" + str2;
            String s2 = str2 + "" + str1;
            return s1.compareTo(s2);
        });
        System.out.println(list);
        for (int s : list) {
            str += s;
        }
        return str;
    }

}
