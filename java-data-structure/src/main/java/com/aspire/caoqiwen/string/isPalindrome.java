package com.aspire.caoqiwen.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class isPalindrome {

    public static void main(String[] args) {
        System.out.println("hello world");
        String s = "hello world";
        System.out.println(isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {

        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            /**
             * 空格直接跳过
             */
            if (!Character.isLetterOrDigit(arr[start])) {
                start++;
            } else if (!Character.isLetterOrDigit(arr[end])) {
                end--;
            } else if (Character.toLowerCase(arr[start++]) != Character.toLowerCase(arr[end--])) {
                return false;
            }

        }
        return true;
    }
}
