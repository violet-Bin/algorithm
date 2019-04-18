package com.algorithm.swordoffer;

/**
 * @Author: jiangjiabin
 * @Description: 给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 解：
 * B0   1   A1  A2   A3  A4  ---  An-2   An-1
 * B1   A0  1   A2   A3  A4  ---  An-2   An-1
 * B2   A0  A1  1    A3  A4  ---  An-2   An-1
 * B3   A0  A1  A2   1   A4  ---  An-2   An-1
 * B4   A0  A1  A2   A3  1   ---  An-2   An-1
 * ---  A0  A1  A2   A3  A4  1    An-2   An-1
 * Bn-2 A0  A1  A2   A3  A4  ---  1      An-1
 * Bn-1 A0  A1  A2   A3  A4  ---  An-2   1
 * <p>
 * B[i]的值可以看作下图的矩阵中每行的乘积。
 * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
 * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，
 * 然后倒过来按上三角中的分布规律，把另一部分也乘进去。
 * @Date: Create in 0:26 2019/4/10
 */
public class Code50Multiply {

    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length != 0) {
            B[0] = 1;
            //计算下三角
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            //计算上三角
            for (int j = length - 2; j >= 0; j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }

}
