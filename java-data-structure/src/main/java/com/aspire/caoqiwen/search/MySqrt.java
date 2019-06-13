package com.aspire.caoqiwen.search;


/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class MySqrt {

    /**
     * 输入: 4
     * 输出: 2
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     * 由于返回类型是整数，小数部分将被舍去。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        int start = 0;
        int end = x;
        while (start < end) {
            int midlle = start + (end - start) / 2;
            if (x / midlle >= midlle) {
                start = midlle + 1;
            } else {
                end = midlle;
            }
        }
        return end - 1;
    }
}
