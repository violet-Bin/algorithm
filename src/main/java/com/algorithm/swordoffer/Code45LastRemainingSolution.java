package com.algorithm.swordoffer;

/**
 * @author: jiangjiabin001
 * @date: 2019/4/9
 * @Description: 每年六一儿童节, 牛客都会准备一些小礼物去看望孤儿院的小朋友,
 * 今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 * 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class Code45LastRemainingSolution {

    public int lastRemainingSolution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int[] array = new int[n];
        int i = -1, step = 0, count = n;
        while (count > 0) {//跳出循环时将最后一个元素也设置为了-1
            i++;           //指向上一个被删除对象的下一个元素。
            if (i >= n) {  //模拟环。
                i = 0;
            }
            if(array[i] == -1) {//跳过被删除的对象。
                continue;
            }
            step++;            //记录已走过的。
            if(step==m) {        //找到待删除的对象。
                array[i]=-1;
                step = 0;
                count--;
            }
        }
        return i;             //返回跳出循环时的i,即最后一个被设置为-1的元素
    }

    public static void main(String[] args) {
        Code45LastRemainingSolution obj = new Code45LastRemainingSolution();
        obj.lastRemainingSolution(10, 5);
    }

}
