package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/4
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 解：其实就是斐波那契数列，比如跳到第六级，
 * 可以从第四级跳上来，也可以从第五级跳上来，所以就有跳到4和5级的次数的和
 */
public class Code07JumpFloor {

    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        int one = 1;
        int two = 2;
        int result = 0;
        for (int i = 3; i < target + 1; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }
}
