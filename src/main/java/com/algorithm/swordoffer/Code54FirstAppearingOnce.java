package com.algorithm.swordoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/10
 * @Description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Code54FirstAppearingOnce {

    HashMap<Character, Integer> map = new HashMap<>();
    ArrayList<Character> list = new ArrayList<>();

    //Insert one char from stringstream
    public void insert(char ch) {
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else{
            map.put(ch,1);
        }
        list.add(ch);
    }

    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        char c='#';
        for(char key : list){
            if(map.get(key)==1){
                c=key;
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("def", 1);
        map.put("abc", 1);
        map.put("zz", 3);
        map.put("bcc", 4);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
