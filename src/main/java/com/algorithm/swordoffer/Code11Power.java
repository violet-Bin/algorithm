package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/4
 * @Description: 给定一个double类型的浮点数base
 * 和int类型的整数exponent。求base的exponent次方。
 */
public class Code11Power {

    public double power(double base, int exponent) {

        double temp = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                temp = temp * base;
                if (temp > Double.MAX_VALUE) {
                    System.out.println("超过最大值！");
                    return -1;
                }
            }
            return temp;
        } else if (exponent < 0) {
            exponent = -exponent;
            for (int i = 0; i < exponent; i++) {
                temp = temp * base;
                if (temp > Double.MAX_VALUE) {
                    System.out.println("超过最大值");
                    return -1;
                }
            }
            temp = 1.0 / temp;
            return temp;
        } else {
            return 1;
        }
    }

}
