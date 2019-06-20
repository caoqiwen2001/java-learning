package com.aspire.caoqiwen.search;

public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println("hello word");
        int[] arr = {3, 5, 3, 1, 2};
        System.out.println(findDuplicate(arr));
    }

    /**
     * 很牛逼的一段代码，很奇妙的思想
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int left = 1;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }


}
