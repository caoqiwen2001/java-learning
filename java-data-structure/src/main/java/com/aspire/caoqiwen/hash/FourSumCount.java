package com.aspire.caoqiwen.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 */
public class FourSumCount {

    public static void main(String[] args) {
        System.out.println("hello world");
//        test1();
    }

    /**
     * 利用HashMap来传值即可。
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                hashMap.put(A[i] + B[j], hashMap.getOrDefault((A[i] + B[j]), 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                count += hashMap.getOrDefault(-C[i] - D[j], 0);
            }
        }
        return count;

    }



    /**
     * getOrDefault 有的话就返回具体的值，没有的话就返回0
     */
    public static void test1() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("0", "1");
        System.out.println(hashMap.getOrDefault("0", "0"));
    }
}
