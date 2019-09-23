package com.aspire.caoqiwen.string;


/*

编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
输入: "hello"
输出: "holle"
 */
public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println("hello world");
        String ss = "hello";
        System.out.println(reverseVowels(ss));
    }

    /**
     * 双指针法，判断是否原因字母
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        int j = s.length() - 1;
        int i = 0;
        char[] arr = s.toCharArray();
        while (i < j) {
            while (i < j && !judgeVowel(arr[i])) {
                i++;
            }
            while (i < j && !judgeVowel(arr[j])) {
                j--;
            }
            swap(i, j, arr);
            i++;
            j--;
        }

        return new String(arr);
    }

    public static void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static boolean judgeVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
