package com.algorithm.swordoffer;

import java.util.ArrayList;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 找出所有和为S的连续正数序列
 * 例如：9~16的和 ，和18,19,20,21,22的和都为S（100）
 * 解：
 * 1）由于我们要找的是和为S的连续正数序列，因此这个序列是个公差为1的等差数列，
 * 而这个序列的中间值代表了平均值的大小。假设序列长度为n，
 * 那么这个序列的中间值可以通过（S / n）得到，知道序列的中间值和长度，也就不难求出这段序列了。
 * 2）满足条件的n分两种情况：
 * n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 && sum % n == 0；
 * n为偶数时，序列中间两个数的平均值是序列的平均值，
 * 而这个平均值的小数部分为0.5，所以条件为：(sum % n) * 2 == n.
 * 3）由题可知n >= 2，那么n的最大值是多少呢？我们完全可以将n从2到S全部遍历一次，
 * 但是大部分遍历是不必要的。为了让n尽可能大，我们让序列从1开始，
 * 根据等差数列的求和公式：S = (1 + n) * n / 2，得到. n < (2S^(1/2))
 * <p>
 * 最后举一个例子，假设输入sum = 100，我们只需遍历n = 13~2的情况（按题意应从大到小遍历），
 * n = 8时，得到序列[9, 10, 11, 12, 13, 14, 15, 16]；
 * n  = 5时，得到序列[18, 19, 20, 21, 22]。
 * 完整代码：时间复杂度为 O(n^(1/2))
 * (sum / n) - (n - 1) / 2 : 第一个数
 */
public class Code40FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Code40FindContinuousSequence obj = new Code40FindContinuousSequence();
        ArrayList<ArrayList<Integer>> continuousSequence = obj.findContinuousSequence(100);
        System.out.println(continuousSequence);
    }
}
