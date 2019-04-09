package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Code30NumberOf1Between1AndN {

    public int numberOf1Between1AndNSolution(int n) {
        int count = 0;
        while (n > 0) {
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    count++;
                }
            }
            n--;
        }
        return  count;
    }
}
