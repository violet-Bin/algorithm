package com.algorithm.leetcode.part00;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jiangjiabin
 * @date: Create in 22:26 2021/2/28
 * @description: 字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数.
 * <p>
 * 状态机
 *              ' '	    +/-	    number	    other
 * start	    start	signed	in_number	end
 * signed	    end	    end	    in_number	end
 * in_number	end	    end	    in_number	end
 * end	        end	    end	    end	        end
 */
public class Code07 {

    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        for (int i = 0; i<s.length(); i++) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }


    public static void main(String[] args) {
        System.out.println(new Code07().myAtoi("a123"));
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    public String state = "start";
    public Map<String, String[]> table = new HashMap<String, String[]>() {
        {
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }
    };

    public void get(char c) {
        state = table.get(state)[getCol(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ?
                    Math.min(ans, (long) Integer.MAX_VALUE) :
                    Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int getCol(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }

}
