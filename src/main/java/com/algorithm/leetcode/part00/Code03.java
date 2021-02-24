package com.algorithm.leetcode.part00;

/**
 * @author: jiangjiabin
 * @date: Create in 22:36 2021/2/24
 * @description: 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class Code03 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //(n1 + n2 + 1) / 2 和 (n1 + n2 + 2) / 2的平均数
        int media1 = (n1 + n2 + 1) / 2;
        int media2 = (n1 + n2 + 2) / 2;
        int i = 0;
        int j = 0;
        int count = 0;
        int[] total = new int[n1 + n2];
        while (i < n1 || j < n2) {
            if (i == n1) {
                total[count++] = nums2[j++];
            } else if (j == n2) {
                total[count++] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                total[count++] = nums1[i++];
            } else {
                total[count++] = nums2[j++];
            }
        }
        return (double) (total[media1 - 1] + total[media2 - 1]) / 2;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(new Code03().findMedianSortedArrays(num1, num2));
    }

}
