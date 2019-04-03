package com.aspire.caoqiwen.arrarList;


import sun.security.util.Length;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * <p>
 * 如果是，则返回最大元素的索引，否则返回-1。
 * nums = [3, 6, 1, 0]
 */
public class ArrCenterMtrixSerach {

    public static void main(String[] args) {
      //  System.out.println("hello world");
        int[] nums = {0, 0, 0, 1};
        System.out.println(maxValPixot(nums));
    }

    public static int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            hashMap.put(nums[i], i);
        }
        Arrays.sort(nums);
        if (nums.length == 1) {
            return 0;
        } else if (nums[length - 2] * 2 <= nums[length - 1]) {
            return hashMap.get(nums[length - 1]);
        } else {
            return -1;
        }

    }

    /**
     * 求最大值
     *
     * @param nums
     * @return
     */
    private static int maxValPixot(int[] nums) {
        int max = -1, maxIndex = -1, secondMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return max >= secondMax * 2 ? maxIndex : -1;
    }
}
