package com.aspire.caoqiwen.string;

import java.util.LinkedList;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 输入为非空字符串且只包含数字 1 和 0。
 * 输入: a = "11", b = "11"
 * 输出: "100"
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(addBinary("11", "11"));
    }

    public static String addBinary(String a, String b) {

        int a_len = a.length(); //字符串的长度
        int b_len = b.length();

        if (a_len > b_len) {
            for (int i = 0; i < a_len - b_len; ++i) {
                b = new StringBuilder(b).insert(0, '0').toString();
            }
            //置加0使两个字符串长度相等
        } else if (a_len < b_len) {
            for (int i = 0; i < b_len - a_len; ++i) {
                a = new StringBuilder(a).insert(0, '0').toString();
            }
        }
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        LinkedList<Character> list = new LinkedList<Character>();
        StringBuilder builder = new StringBuilder();
        boolean addFalg = false;
        int sum;
        for (int i = a.length() - 1; i >= 0; i--) {
            int aa1 = Integer.parseInt(String.valueOf(aa[i]));
            int bb1 = Integer.parseInt(String.valueOf(bb[i]));
            sum = aa1 + bb1;
            if (sum == 2 && addFalg == false) {
                addFalg = true;
                list.add('0');
            } else if (sum == 2 && addFalg) {
                addFalg = true;
                list.add('1');
            } else if (sum == 1 && addFalg) {
                list.add('0');
                addFalg = true;
            } else if (sum == 1 && addFalg == false) {
                list.add('1');
            } else if (sum == 0 && addFalg) {
                list.add('1');
                addFalg = false;
            } else if (sum == 0 && addFalg == false) {
                list.add('0');
            }
        }
        if (addFalg) {
            list.add('1');
        }
        while (list.size() > 0) {
            Character character = list.pollLast();
            builder.append(character);
        }
        return builder.toString();
    }
}
