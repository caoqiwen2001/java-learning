package com.aspire.caoqiwen.search;

/**
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 数组中可能存在重复的元素。
 * <p>
 * 示例 2：
 * <p>
 * 输入: [2,2,2,0,1]
 * 输出: 0
 */
public class FindMin2 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 0, 1};
        System.out.println(findMin(nums));

    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];

    }

}
