package com.aspire.caoqiwen.search;

import java.util.ArrayList;
import java.util.List;

/***
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(searchRange(nums, 8));
    }

    /**
     * 首先在左边找，匹配的值
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        result[0] = searchRangeLeft(nums, target);
        if (result[0] != -1) {
            result[1] = searchRangeRight(nums, result[0], target);
        }
        return result;


    }

    /**
     * 然后找右边的值
     *
     * @param nums
     * @param target
     * @return
     */
    private static int searchRangeLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftInit = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                leftInit = mid;
                right = mid - 1;
            }

        }
        return leftInit;
    }


    public static int searchRangeRight(int[] nums, int left, int target) {
        int right = nums.length - 1;
        int rightInit = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                rightInit = mid;
                left = mid + 1;
            }
        }
        return rightInit;
    }

}
