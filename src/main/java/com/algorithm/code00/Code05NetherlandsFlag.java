package com.algorithm.code00;

/**
 * @Author: jiangjiabin
 * @Description: 荷兰国旗问题：小于num的数放右边，大于num的数放左边，等于的放中间
 * @Date: Create in 11:17 2019/2/22
 */
public class Code05NetherlandsFlag {

    public static int[] partition(int[] arr, int l, int r, int num) {
        int less = l - 1;
        int more = r + 1;
        int cur = l;
        while (cur < more) {
            if (arr[cur] < num) {
                Common.swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                Common.swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};//返回的是等于的左右边界的index
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        Common.printArray(test);
        int[] res = partition(test, 0, test.length - 1, 5);
        Common.printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }


}
