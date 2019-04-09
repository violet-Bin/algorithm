package com.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到
 * 第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Code33FirstNotRepeatingChar {

    public int firstNotRepeatingChar(String str) {

        if (str == null || str.length() == 0) {
            return -1;
        }
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!list1.contains(ch)) {
                list1.add(Character.valueOf(ch));
            } else {
                list1.remove(Character.valueOf(ch));
                list2.add(Character.valueOf(ch));
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            if (list1.contains(list2.get(i))) {
                list1.remove(list2.get(i));
            }
        }
        if (list1.size() <= 0) {
            return -1;
        }
        return str.indexOf(list1.get(0));
    }

    public static void main(String[] args) {
        Code33FirstNotRepeatingChar obj = new Code33FirstNotRepeatingChar();
        int index = obj.firstNotRepeatingChar("qwertyuqwerqwe");
        System.out.println(index);
    }

}
