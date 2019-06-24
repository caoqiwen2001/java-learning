package com.aspire.caoqiwen.search;


/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println("hello world");

        System.out.println(myPow(2.0, 10));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        if (n > 0) {
            return half * half * x;
        }

        return half * half / x;
    }
}
