package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/8
 * @Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 注：最后一个是根
 * 10
 * /    |
 * 5     17
 * /  |  /  |
 * 2  7  12  19
 * 后序：| - 2 7 5 - | - 12 19 17 - | 10
 * 前半（右边）小于10   后半（左边）大于10   不满足这个条件肯定就不是二叉树
 * 再判断子树   | - 2 7 - | 5      | - 12 19- | 17
 */
public class Code22VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return isTreeBST(sequence, 0, sequence.length - 1);
    }

    private boolean isTreeBST(int[] sequence, int start, int end) {
        if (end <= start) {
            return true;
        }
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        return isTreeBST(sequence, start, i - 1) && isTreeBST(sequence, i, end - 1);
    }
}
