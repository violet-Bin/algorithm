package com.algorithm.leetcode.part00;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiangjiabin
 * @date: Create in 17:09 2021/2/27
 * @description: Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class Code05 {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        //应该有 Math.min(numRows, s.length()) 行
        int rowNum = Math.min(numRows, s.length());
        for (int i = 0; i < rowNum; i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code05().convert("PAY", 4));
        //PAHNAPLSIIGYIR
        //PAHNAPLSIIGYIR
    }
}
