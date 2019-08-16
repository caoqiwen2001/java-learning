package com.aspire.caoqiwen.recursive;


import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Generate {

    public static void main(String[] args) {
        System.out.println("hello world");
        List<List<Integer>> list = generate(30);
        System.out.println("done");
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list1 = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int result = generate1(i, j);
                list1.add(result);
            }
            list.add(list1);
        }

        return list;
    }


    private static int generate1(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        } else {
            return generate1(i - 1, j - 1) + generate1(i - 1, j);
        }
    }
}
