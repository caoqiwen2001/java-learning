package lettercode01;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */

public class Lettercode14 {

    public static void main(String[] args) {
        String[] str2 = {"c", "acc", "ccc"};
        System.out.println(longestCommonPrefix(str2));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }
        if (pre.isEmpty()) return "";
        return pre;
    }
}
