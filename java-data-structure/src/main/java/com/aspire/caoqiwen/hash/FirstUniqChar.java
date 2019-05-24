package com.aspire.caoqiwen.hash;

public class FirstUniqChar {

    public static void main(String[] args) {
//        System.out.println("hello world");
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {

        char[] arr = s.toCharArray();
        int[] result = new int[256];
        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            result[arr[i] - 'a'] += count;
        }

        for (int i = 0; i < arr.length; i++) {
            if (result[arr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
