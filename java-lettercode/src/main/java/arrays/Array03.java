package arrays;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.*;


/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class Array03 {

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list1 = getList(str);

    }

    public static List<List<String>> getList(String[] str) {
        HashMap<String, List<String>> hashMaps = new HashMap<>();
        for (String s : str) {
            char[] str3 = s.toCharArray();
            Arrays.sort(str3);
            String str5 = String.valueOf(str3);
            if (!hashMaps.containsKey(str5)) {
                hashMaps.put(str5, new ArrayList<>());
            }
            hashMaps.get(str5).add(s);
        }
        return new ArrayList<>(hashMaps.values());
    }
}
