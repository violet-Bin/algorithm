package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description:  student a am I  -->  I am a student
 */
public class Code43ReverseSentence {

    public String reverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = a.length; i > 0; i--) {
            o.append(a[i - 1]);
            if (i > 1) {
                o.append(" ");
            }
        }
        return o.toString();
    }

}
