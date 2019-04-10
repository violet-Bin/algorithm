package com.algorithm.swordoffer;

/**
 * @Author: jiangjiabin
 * @Description: 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * (n+n*n)/2
 * @Date: Create in 23:40 2019/4/9
 */
public class Code46SumSolution {

    public int sumSolution(int n) {
        int sum = (int) (Math.pow(n, 2) + n);
        return sum >> 1;
    }

}
