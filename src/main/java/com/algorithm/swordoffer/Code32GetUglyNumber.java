package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 求按从小到大的顺序的第N个丑数。
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。
 */
public class Code32GetUglyNumber {

    public int getUglyNumberSolution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] result = new int[index];
        int count = 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        result[0] = 1;
        int temp;
        while (count < index - 1) {
            temp = min(result[i2] * 2, min(result[i3] * 3, result[i5] * 5));
            if (temp == result[i2] * 2) {
                i2++;
            }
            if (temp == result[i3] * 3) {
                i3++;
            }
            if (temp == result[i5] * 5) {
                i5++;
            }
            result[++count] = temp;
        }
        return result[index - 1];
    }

    private int min(int a, int b) {
        return (a > b) ? b : a;
    }

    public static void main(String[] args) {
        Code32GetUglyNumber obj = new Code32GetUglyNumber();
        int num = obj.getUglyNumberSolution(7);
        System.out.println(num);
    }

}
