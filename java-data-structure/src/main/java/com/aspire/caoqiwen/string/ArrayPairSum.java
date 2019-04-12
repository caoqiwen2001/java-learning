package com.aspire.caoqiwen.string;

import java.util.Arrays;

public class ArrayPairSum {


    /**
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
     *
     * 输入: [1,4,3,2]
     *
     * 输出: 4
     * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] nums = {1, 3, 2, 4};
        System.out.println(arrayPairSum(nums));
    }

    public static int arrayPairSum(int nums[]) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
