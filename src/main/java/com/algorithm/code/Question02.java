package com.algorithm.code;

import java.util.Stack;

/**
 * @author: jiangjiabin
 * @date: Create in 21:16 2021/2/22
 * @description:
 */
public class Question02 {

    public String solution(String input){
        if(input == null){
            return null;
        }
        String[] strArr = input.split("_");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < strArr.length; i++){
            stack.push(strArr[i]);
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.empty()){
            builder.append(stack.pop()).append("_");
        }
        String result = builder.toString();
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Question02().solution("abc_bbb_123_sdf"));
    }


}
