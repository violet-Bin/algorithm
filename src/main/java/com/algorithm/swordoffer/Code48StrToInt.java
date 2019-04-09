package com.algorithm.swordoffer;

/**
 * @Author: jiangjiabin
 * @Description: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * @Date: Create in 0:00 2019/4/10
 */
public class Code48StrToInt {

    public int StrToInt(String str) {
        if (str.equals("") || str.length() == 0) {
            return 0;
        }
        char[] a = str.toCharArray();
        int fuhao = 0;
        if (a[0] == '-') {
            fuhao = 1;
        }
        int sum = 0;
        for (int i = fuhao; i < a.length; i++) {
            if (a[i] == '+') {
                continue;
            }
            if (a[i] < 48 || a[i] > 57) { //(a[i] < '0' || a[i] > ''9)
                return 0;
            }
            sum = sum * 10 + a[i] - 48;
        }
        return fuhao == 0 ? sum : sum * -1;
    }

}
