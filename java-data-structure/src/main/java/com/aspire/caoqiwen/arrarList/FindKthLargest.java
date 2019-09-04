package com.aspire.caoqiwen.arrarList;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，
 * 你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class FindKthLargest {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {5, 2, 4, 1, 3, 6, 0};
        findKthLargest(arr, 4);
    }


    public static int findKthLargest(int[] nums, int k) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        Arrays.sort(nums);
//        int max = nums[nums.length] - 1;
//        int index = 1;
//        for (int i = nums.length; i > 0; i--) {
//            if (nums[i] < max) {
//                ++index;
//            }
//            if (index == k) {
//                return nums[i];
//            }
//        }
//
//        return 0;

        int len = nums.length;
        if (k > len) {
            return 0;
        }

        int start = 0;
        int end = len - 1;
        int index = partion(nums, start, end);
        while (index != len - k) {
            if (index > len - k) {
                end = index - 1;
                index = partion(nums, start, end);
            } else if (index < len - k) {
                start = index + 1;
                index = partion(nums, start, end);
            }
        }
        return nums[index];

    }


    /**
     * 采用快速排序的方法来实现
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int partion(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        int pivot = nums[start];
        if (i >= j) {
            return i;
        }

        while (i < j) {
            while (pivot <= nums[j] && i < j) {
                j--;
            }
            while (pivot >= nums[i] && i < j) {
                i++;
            }

            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[start] = nums[i];
        nums[i] = pivot;
        return i;
    }

}
