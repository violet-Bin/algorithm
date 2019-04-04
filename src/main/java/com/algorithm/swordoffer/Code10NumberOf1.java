package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/4
 * @Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Code10NumberOf1 {

    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >>> 1;   //注意！！
        }
        return count;
    }

    public static void main(String[] args) {
        Code10NumberOf1 obj = new Code10NumberOf1();
        int count = obj.numberOf1(7);
        System.out.println(count);
    }


}
