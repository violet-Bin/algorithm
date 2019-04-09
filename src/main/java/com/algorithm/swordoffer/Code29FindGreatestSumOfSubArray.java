package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 给一个数组，返回它的最大连续子序列的和(子向量的长度至少是1)
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 */
public class Code29FindGreatestSumOfSubArray {

    public int findGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int res = array[0]; // 记录当前所有子数组的和的最大值
        int max = array[0]; // 包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max  = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6,-3,-2,7,-15,1,2,14};
        Code29FindGreatestSumOfSubArray obj = new Code29FindGreatestSumOfSubArray();
        obj.findGreatestSumOfSubArray(arr);
    }

}
