package com.algorithm.swordoffer;

/**
 * @Author: jiangjiabin001
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 解：类似于冒泡，依次交换
 * @Date: Create in 23:28 2019/4/4
 */
public class Code12ReOrderArray {

    public void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 3, 4, 3, 7, 3, 4};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        Code12ReOrderArray obj = new Code12ReOrderArray();
        obj.reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
