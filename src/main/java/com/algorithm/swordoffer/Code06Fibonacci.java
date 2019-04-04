package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/4
 * @Description: 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 1 1 2 3 5 8 13 21 34 55...
 */
public class Code06Fibonacci {

    public int Fibonacci(int n) {
        int a = 1, b = 1, c = 0;
        if (n < 0) {
            return 0;
        } else if (n ==1 | n == 2) {
            return 1;
        } else {
            for (int i = 3; i <= n; i++) {
                c = a + b;
                b = a;
                a = c;
            }
            return c;
        }
    }

    public static void main(String[] args) {
        Code06Fibonacci obj = new Code06Fibonacci();
        int fibonacci = obj.Fibonacci(3);
        System.out.println(fibonacci);
    }
}
