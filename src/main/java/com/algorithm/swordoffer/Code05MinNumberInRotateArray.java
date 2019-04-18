package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/4
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Code05MinNumberInRotateArray {

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else {
                if (i == array.length - 2) {
                    return array[0];
                }
            }
        }
        return 0;
    }

    /**
     * 二分查找
     *
     * @return
     */
    public int findMinNum(int[] array) {
        if (array == null) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        //循环结束条件是low == high
        while (low < high) {
            //中间下标，如果有奇数个元素，则mid位于正中间，
            // 如果有偶数个元素，则mid是最中间两个元素靠前的那一个。
            int mid = low + (high - low) / 2;
            //判断中间值和最后值哪个大
            //如果中间大，则小值位于后半段，且不包括后半段，low = mid + 1;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else {
                //如果中间值较小，则小值位于前半段，
                // 有可能包括mid,因为mid现在较小，比如3 1 2，所以high = mid
                high = mid;
            }
        }
        return array[low];
    }
}
