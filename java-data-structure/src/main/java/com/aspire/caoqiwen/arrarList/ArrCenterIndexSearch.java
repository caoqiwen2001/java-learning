package com.aspire.caoqiwen.arrarList;

public class ArrCenterIndexSearch {


    public static void main(String[] args) {
        System.out.println("hello world");
        int[] nums = {1, 2, 3};
        System.out.println(pivotIndex(nums));

    }

    public static int pivotIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int left = i - 1;
            int right = i + 1;
            int leftSum = 0;
            int rightSum = 0;
            while (left >= 0) {
                leftSum += nums[left--];
            }

            while (right < length) {
                rightSum += nums[right++];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}
