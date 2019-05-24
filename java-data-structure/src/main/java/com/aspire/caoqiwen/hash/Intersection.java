package com.aspire.caoqiwen.hash;

import java.math.BigDecimal;
import java.util.*;

public class Intersection {


    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * [1,2,3]  [2,3,4]
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {1, 2, 3};
        int[] arr1 = {2, 3, 4};
        int[] result = intersection(arr, arr1);
        System.out.println("hello word");




    }


    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashSet = new HashSet();
        Set<Integer> hashSet1 = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i])) {
                hashSet1.add(nums2[i]);
            }
        }
        int[] arr2 = new int[hashSet1.size()];
        int i = 0;
        for (Integer integer : hashSet1) {
            arr2[i++] = integer;
        }
        return arr2;

    }


}
