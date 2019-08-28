package com.aspire.caoqiwen.arrarList;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    public static void main(String[] args) {
        System.out.println("1234");
        int[] arr = new int[]{2, 2, 3, 4, 5, 6};
        System.out.println(removeElement(arr, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int numIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[numIndex] = nums[i];
                numIndex++;
            }
        }
        return numIndex;
    }
}
