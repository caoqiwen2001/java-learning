package com.aspire.caoqiwen.arrarList;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {


    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {3, 2, 3};
        System.out.println(majorityElement(arr));
    }


    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer val = entry.getValue();
            Integer key = entry.getKey();
            if (val > max) {
                max = val;
                index = key;
            }
        }
        return index;

    }
}
