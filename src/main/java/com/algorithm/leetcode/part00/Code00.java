package com.algorithm.leetcode.part00;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jiangjiabin
 * @date: Create in 0:07 2021/2/22
 * @description: 两数之和
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2。
 * 注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解，同一个元素不能使用两遍。
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 */
public class Code00 {

    /**
     * 暴力解法：遍历数组
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     */
    public int[] twoSum1(int[] arr, int target) {
        if (arr.length < 1) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    /**
     * 哈希表：遍历一遍数组，判断map中是否包含target - arr[i]；
     * 如果包含，则找到了这两个数；如果不包含，则将其放入map.
     * map的key是arr[i]，value是index.
     * 时间复杂度：O(N)，对于每一个元素arr[i]，可以以O(1)地寻找target-arr[i]
     * 空间复杂度：O(N)
     */
    public int[] twoSum2(int[] arr, int target) {
        if (arr.length < 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target - arr[i]) + 1, i + 1};
            } else {
                map.put(arr[i], i);
            }
        }
        return null;
    }


    public static void main(String[] args) {

    }


}
