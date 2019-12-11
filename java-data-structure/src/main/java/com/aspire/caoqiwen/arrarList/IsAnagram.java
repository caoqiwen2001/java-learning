package com.aspire.caoqiwen.arrarList;


import java.util.Arrays;


/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("st", "ts"));
    }


    public static boolean isAnagram(String s, String t) {

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return java.lang.String.valueOf(sChars).equals(java.lang.String.valueOf(tChars));

    }
}
