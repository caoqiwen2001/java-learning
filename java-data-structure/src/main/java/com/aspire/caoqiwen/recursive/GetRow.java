package com.aspire.caoqiwen.recursive;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public static void main(String[] args) {
        System.out.println("hellp world");
        List<Integer> reult = getRow(33);
        System.out.println("done");

    }


    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j <= rowIndex; j++) {
            int result = generate1(rowIndex, j);
            list.add(result);
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
