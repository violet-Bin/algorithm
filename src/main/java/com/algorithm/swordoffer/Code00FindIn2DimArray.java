package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/4
 * @Description: 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 1 2 3 4
 * 5 6 7 8
 */
public class Code00FindIn2DimArray {

    public boolean find(int target, int[][] array) {

        int len = array.length - 1;
        int i = 0;
        while ((len >= 0) && (i < array[0].length)) {
            if (array[len][i] > target) {
                len--;
            } else if (array[len][i] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        int target = 4;
        Code00FindIn2DimArray obj = new Code00FindIn2DimArray();
        boolean b = obj.find(target, array);
        System.out.println(b);
    }
}
