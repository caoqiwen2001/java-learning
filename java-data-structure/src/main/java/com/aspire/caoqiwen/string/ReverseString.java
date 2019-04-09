package com.aspire.caoqiwen.string;

public class ReverseString {

    public static void main(String[] args) {
        System.out.println("hello word");
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }


    public static void reverseString(char[] s) {
        int length = s.length;
        int i = 0;
        int j = length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
