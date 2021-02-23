package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/4
 * @Description: 请实现一个函数，将一个字符串中的每个空格替换成"%20"。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Code01ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuffer newStr = new StringBuffer();
        for (int i = 0, len = str.length(); i < len; i++) {
            if (str.charAt(i) == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("dsfs dfs  ad fsf ");
        Code01ReplaceSpace obj = new Code01ReplaceSpace();
        String s = obj.replaceSpace(str);
        System.out.println(s);
    }
}
