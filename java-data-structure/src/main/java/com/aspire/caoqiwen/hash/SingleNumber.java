package com.aspire.caoqiwen.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = new int[]{1, 2, 2, 3, 3};
//        System.out.println(containsDuplicate(arr));
        System.out.println(singleNumber((arr)));
    }

    public static int singleNumber(int[] nums) {

        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i] ^ num;
        }
        return num;


    }

}
