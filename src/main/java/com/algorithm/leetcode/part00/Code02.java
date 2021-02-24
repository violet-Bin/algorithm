package com.algorithm.leetcode.part00;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: jiangjiabin
 * @date: Create in 0:38 2021/2/24
 * @description: 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例：
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Code02 {

    /**
     * 滑动窗口：
     *
     */
    public int lengthOfLongestSubstring(String input) {
        //hash集合用来记录字符是否出现过
        Set<Character> occ = new HashSet<>();
        int length = input.length();
        //右指针，滑动窗口的右边界
        int rk = 0;
        int result = 0;
        //i为左指针
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                //当左指针右移一格时，移除一个字符
                occ.remove(input.charAt(i - 1));
            }
            while (rk < length && !occ.contains(input.charAt(rk))) {
                occ.add(input.charAt(rk));
                rk++;
            }
            result = Math.max(result, rk - i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code02().lengthOfLongestSubstring("abcabcbb"));
    }

}
