package com.aspire.caoqiwen.hash;


/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * nums = [1,2,3,1], k = 3
 */
public class ContainsNearbyDuplicate {


    public static void main(String[] args) {
        System.out.println("hello world");
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (Math.abs(i - j) <= k && j < nums.length) {
                if (nums[i] == nums[j++]) {
                    return true;
                }
            }
        }
        return false;
    }
}
