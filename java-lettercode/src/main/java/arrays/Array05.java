package arrays;

public class Array05 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba"也是一个有效答案。
     * <p>
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * 5,8.7,8
     *
     * @param args
     */

    private static int lo, maxLen = 1;

    public static void main(String[] args) {
        String s = "aa";
        Array05 array05 = new Array05();
        System.out.println(array05.longestPalindrome(s));

    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            maxLength(i, i + 1, s);
        }
        return s.substring(Array05.lo, Array05.lo + Array05.maxLen);

    }


    public void maxLength(int i, int j, String s) {

        while (i >= 0 && j < s.length()) {
            if (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                if (Array05.maxLen < j - i + 1) {
                    Array05.maxLen = j - i + 1;
                    Array05.lo = i;
                }
            }
            i--;
        }
    }
}
