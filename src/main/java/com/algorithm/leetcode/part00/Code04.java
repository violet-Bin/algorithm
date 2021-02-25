package com.algorithm.leetcode.part00;

/**
 * @author: jiangjiabin
 * @date: Create in 23:38 2021/2/25
 * @description: 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 */
public class Code04 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start , end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //因为跳出循环的时候，左右边界各多算了一个字符，由于相减求长度的时候应加1，综合只需减1即可。
        return right -left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code04().longestPalindrome("bb"));

        System.out.println("asdf".substring(0, 2));
    }
}
