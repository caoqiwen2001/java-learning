package com.aspire.caoqiwen.arrarList;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = new int[]{0, 1, 1, 2, 2, 2};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[number] != nums[i]) {
                number++;
                nums[number] = nums[i];
            }
        }
        return number + 1;
    }

}
