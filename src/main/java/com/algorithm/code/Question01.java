package com.algorithm.code;

/**
 * @author: jiangjiabin
 * @date: Create in 18:33 2021/2/20
 * @description: 给定一个字符串，包含数字和字母，找出最大的
 */
public class Question01 {

    volatile int flag = 1;

    public void maxNum(String input) {
        int length = input.length();
        int index = 0;
        int max = 0;
        StringBuilder sb = new StringBuilder();
        while (index < length) {
            char c = input.charAt(index++);
            if (c < 'a') {
                sb.append(c);
            } else if (sb.length() != 0) {
                max = Math.max(max, Integer.valueOf(sb.toString()));
                sb = new StringBuilder();
            }
        }
        if (sb.length() != 0) {
            max = Math.max(max, Integer.valueOf(sb.toString()));
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        new Question01().maxNum("asdasd12345sdfsdf2fsf67891");

    }
}
