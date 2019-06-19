package com.aspire.caoqiwen.search;

public class IsPerfectSquare {

    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(isPerfectSquare(2147483647));
    }


    public static boolean isPerfectSquare(int num) {
        if (num == 0) {
            return true;
        }
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //防止超出范围
            long temp = (long) (mid * 1.0 * mid);
            if (temp == num) {
                return true;
            } else if (temp > num) {
                right = mid - 1;
            } else if (temp < num) {
                left = mid + 1;
            }
        }
        return false;
    }
}
