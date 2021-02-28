package com.algorithm.leetcode.part00;

import java.util.Stack;

/**
 * @author: jiangjiabin
 * @date: Create in 20:30 2021/2/28
 * @description: 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 */
public class Code06 {

    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            x = Math.abs(x);
            negative = true;
        }
        String s = String.valueOf(x);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        int maxValue = Integer.MAX_VALUE;

        int result = Integer.valueOf(sb.toString());
        result = negative ? -result : result;
        return result;
    }

    public int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            result = result * 10 + pop;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code06().reverse2(-1534236469));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        //2147483647
    }
}
