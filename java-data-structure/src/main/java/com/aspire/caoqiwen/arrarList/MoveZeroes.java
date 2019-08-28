package com.aspire.caoqiwen.arrarList;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */


public class MoveZeroes {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = new int[]{1, 0, 0, 2, 3, 4, 5};
        moveZeroes(arr);
        System.out.println("done");
    }

    public static void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroIndex] = nums[i];
                zeroIndex++;
            }
        }

        for (int i = zeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }


    }

}
