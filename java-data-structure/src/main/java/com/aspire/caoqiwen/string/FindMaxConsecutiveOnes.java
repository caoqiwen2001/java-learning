package com.aspire.caoqiwen.string;

import sun.security.util.Length;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 */
public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] arr = {0, 0};
        System.out.println(findMaxConseutesie(arr));
    }

    /**
     * 这种方法经过测试需要315ms，太慢了
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int lenth = nums.length;
        if (nums.length == 1 && nums[0] == 0) {
            return 0;
        } else if (nums.length == 1 && nums[0] == 1) {
            return 1;
        }
        for (int i = 0; i < lenth; i++) {
            int temp;
            if (nums[i] == 0) {
                temp = 0;
            } else {
                temp = 1;
            }

            for (int j = i + 1; j < lenth; j++) {
                if (nums[i] == nums[j] && nums[i] == 1) {
                    temp = j - i + 1;
                } else {
                    break;
                }
            }
            max = temp > max ? temp : max;
        }
        return max;

    }

    /**
     * 循环遍历所有的数字。保存当前及当前的下一个数字即可
     *
     * @param nums
     * @return
     */
    public static int findMaxConseutesie(int[] nums) {
        int max = 0, cur = 0;
        for (int num : nums) {
            cur = num == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
