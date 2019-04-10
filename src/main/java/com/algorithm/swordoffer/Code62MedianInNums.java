package com.algorithm.swordoffer;

import java.util.LinkedList;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/10
 * @Description: 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Code62MedianInNums {

    LinkedList<Integer> list = new LinkedList<Integer>();

    public void Insert(Integer num) {
        if (list.size() == 0 || num < list.getFirst()) {
            list.addFirst(num);
        } else {
            boolean insertFlag = false;
            for (Integer e : list) {
                if (num < e) { //2 5 6 7 9   <-   6
                    int index = list.indexOf(e);
                    list.add(index, num);
                    insertFlag = true;
                    break;
                }
            }
            if (!insertFlag) {
                list.addLast(num);
            }
        }
    }

    public Double GetMedian() {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() % 2 == 0) {//偶数个数
            int i = list.size() / 2;//假如10个数，i = 5    1 2 3 4 | 5 6 | 7 8 9 10
            double a = (double) (list.get(i - 1) + list.get(i));
            return a / 2;
        }
        //奇数个数  1 2 3 | 4 | 5 6 7
        return Double.valueOf(list.get((list.size() - 1) / 2));
    }
}
