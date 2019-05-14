package com.aspire.caoqiwen.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println("hello wolrd");
        int[] nums = {2, 7, 11, 15};
        int aa[] = twoSum(nums, 9);
        System.out.println("done");
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        Arrays.sort(nums);
        int length = nums.length;
        boolean hasFind = false;
        int start = 0;
        int end = length - 1;
        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] == target) {
                hasFind = true;
                start = nums[start];
                end = nums[end];
                break;
            }
        }
        if (hasFind) {
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                Integer value = (Integer) entry.getValue();
                if (value == start || value == end) {
                    result[i++] = (Integer) entry.getKey();
                    ;
                }

            }
        }
        return result;
    }
}
