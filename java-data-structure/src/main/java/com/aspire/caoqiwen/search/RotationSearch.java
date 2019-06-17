package com.aspire.caoqiwen.search;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 搜索旋转排序数组
 */
public class RotationSearch {

    public static void main(String[] args) {
        System.out.println("hello word");

        int[] test = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(test, 2));
    }

    public static int search(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return maps.get(nums[mid]);
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
