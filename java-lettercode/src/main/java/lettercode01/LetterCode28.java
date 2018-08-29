package lettercode01;

public class LetterCode28 {
    /**
     * 实现 strStr() 函数。
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * 解题思路：每次需要遍历字符的个数为两个字符串之差，从第一个字符开始遍历，一个for循环搞定，时间复杂度为O(N)
     */

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();
        if (length2 == 0 || haystack.equals(needle)) {
            return 0;
        }
        int throld = length1 - length2;
        for (int i = 0; i <= throld; i++) {
            if (haystack.substring(i, i + length2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }


}
