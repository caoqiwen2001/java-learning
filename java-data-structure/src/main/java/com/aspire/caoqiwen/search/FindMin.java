package com.aspire.caoqiwen.search;

/**
 * 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class FindMin {
    public static void main(String[] args) {
        System.out.println("hello word");
        int[] nums = {3, 1, 2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int middle = 0;
        while (left < right) {
            middle = (right - left) / 2 + left;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle ;
            }
        }
        return nums[left];
    }
}
