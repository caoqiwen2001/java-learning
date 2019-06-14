package com.aspire.caoqiwen.search;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 */
public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println("hello word");
        int[] nums = {1, 2};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] >= nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }


}
