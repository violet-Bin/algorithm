package com.algorithm.swordoffer;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author: mailto:jiangjiabin001
 * @date: 2019/4/8
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））。
 * 注：除了迭代器，还可以用辅助栈 存min————
 * 压的时候，如果A栈的压入比B栈大，B栈不压，小于等于，AB同时压入；
 * 出栈，AB栈顶元素等才都出。
 */
public class Code19MinNumInStack {

    Stack<Integer> stack = new Stack<>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = stack.peek();
        int temp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (min > temp) {
                min = temp;
            }
        }
        return min;
    }

}
