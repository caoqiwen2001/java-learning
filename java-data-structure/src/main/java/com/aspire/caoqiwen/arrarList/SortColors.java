package com.aspire.caoqiwen.arrarList;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 */
public class SortColors {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
        System.out.println(arr);
    }


    /**
     * 利用计数排序解决。还有其他的解决办法
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int[] arr = new int[3];
        int idex = 0;
        for (int i = 0; i < nums.length; i++) {
            ++arr[nums[i]];
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arr[i]; j++) {
                nums[idex++] = i;
            }
        }

    }
}
