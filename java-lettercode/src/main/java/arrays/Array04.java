package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Array04 {
    /**
     * 给定一个字符串，找出不含有重复字符的最长子串的长度。
     * <p>
     * 示例：
     * <p>
     * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
     * <p>
     * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
     * <p>
     * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
     * 解题思路：
     *
     * @param args
     */

    public static void main(String[] args) {
        String aaa = "pwwkew";
        System.out.println(lengthOfLongestSubstring(aaa));

    }

    /**
     * 用HashMap记录下当前的位置，每次去减掉之前那一个就可以了。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> maps = new HashMap<>();
        int length = s.length(), ans = 0;
        for (int i = 0, j = 0; j < length; j++) {
            if (maps.containsKey(s.charAt(j))) {
                i = Math.max(maps.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i);
            maps.put(s.charAt(j), j );

        }
        return ans;
    }
}
