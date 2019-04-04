package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/4
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 解：f(n) = 2 * f(n - 1)
 *
 * f(1) = 1
 * f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
 * f(3) = f(3-1) + f(3-2) + f(3-3)
 * ...
 *
 * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)
 * 因为 f(n-1) = f(n-2) + (n-3) + ... + f(1)
 * 所以 f(n) = 2 * f(n-1)
 *
 * 说明：
 * 1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。
 * 2）n = 1时，只有1种跳法，f(1) = 1
 * 3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)
 * 4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，
 * 那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
 * 因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
 * 5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
 * f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n)
 */
public class Code08JumpFloorII {

    public int jumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * jumpFloorII(target - 1);
        }
//        return 1 << (target - 1);
    }

    public static void main(String[] args) {
        Code08JumpFloorII obj = new Code08JumpFloorII();
        System.out.println(obj.jumpFloorII(4));
    }
}
