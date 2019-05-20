package com.aspire.caoqiwen.hash;

import java.util.*;

public class Intersect {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("hello world");
        int[] nums = {2, 2, 5};
        int[] nums1 = {2, 2, 2, 8, 4};
        int[] result = intersect(nums, nums1);
        System.out.println("end");

    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (list.remove((Object) nums2[i])) {
                list1.add(nums2[i]);
            }
        }
        return list1.stream().mapToInt(Integer::valueOf).toArray();
    }
}
