package com.aspire.caoqiwen.arrarList;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates2 {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = new int[]{0, 1, 1, 2, 2, 2};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int number = 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] == nums[i]) {
                number++;
                if (number < 2) {
                    nums[++j] = nums[i];
                }
            } else {
                nums[++j] = nums[i];
                number = 0;
            }
        }
        return j + 1;
    }
}
