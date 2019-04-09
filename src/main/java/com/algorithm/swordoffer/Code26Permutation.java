package com.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Code26Permutation {

    public ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> temp = new TreeSet<>();
        permutation(chars, 0, temp);
        result.addAll(temp);
        return result;
    }

    private void permutation(char[] chars, int begin, TreeSet<String> result) {
        if (chars == null || chars.length == 0 || begin < 0 || begin > chars.length - 1) {
            return;
        }
        if (begin == chars.length - 1) {
            result.add(String.valueOf(chars));
        } else {
            for (int i = begin; i < chars.length; i++) {
                swap(chars, begin, i);
                for (int k = 0; k < chars.length; k++) {
                    System.out.println(chars[k]);
                }
                System.out.println(" ");
                permutation(chars, begin + 1, result);
                swap(chars, begin, i);
            }
        }
    }

    private void swap(char[] chars, int begin, int i) {
        char t = chars[begin];
        chars[begin] = chars[i];
        chars[i] = t;
    }

    public static void main(String[] args) {
        String str = "abc";
        Code26Permutation obj = new Code26Permutation();
        obj.permutation(str);
    }
}
