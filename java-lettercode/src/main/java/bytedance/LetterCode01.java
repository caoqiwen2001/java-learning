package bytedance;

import java.util.*;

public class LetterCode01 {

    /**
     * 通过窗口滑动进行确认
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * <p>
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * @param args
     */

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion1(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int[] count1 = new int[26]; // s1每个字符出现的次数
        int[] count2 = new int[26]; // s2每个字符出现的次数
        // 1. 进行统计
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        // 2. 滑动窗口，滑块长度始终为 s1.length()
        for (int i = s1.length(); i < s2.length(); i++) {
            if (isSame(count1, count2)) {
                return true;
            }
            count2[s2.charAt(i - s1.length()) - 'a']--; // 去掉滑块当前的首个字符
            count2[s2.charAt(i) - 'a']++; // 添加最新的字符到滑块中
        }
        return isSame(count1, count2);
    }

    // 有且仅当 count1 中所有值都等于 count2 中对应值时满足条件
    public static boolean isSame(int[] count1, int[] count2) {
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用另外一种窗口方法。每次滑动s1.length的长度
     */

    public static boolean checkInclusion1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        List<Character> c1 = new LinkedList<>();
        List<Character> c2 = new LinkedList<>();
        for (int i = 0; i < s1.length(); i++) {
            c1.add(s1.charAt(i));
            c2.add(s2.charAt(i));
        }
        List<Character> list1 = new LinkedList<>();
        List<Character> list2 = new LinkedList<>();

        for (int k = s1.length(); k < s2.length(); k++) {
            list1.clear();
            list2.clear();
            for (int i = 0; i < c1.size(); i++) {
                list1.add(c1.get(i));
                list2.add(c2.get(i));
            }
            if (sameCharacter(list1, list2)) {
                return true;
            }
            c2.remove(0);
            c2.add(s2.charAt(k));
        }

        list1.clear();
        list2.clear();
        for (int i = 0; i < c1.size(); i++) {
            list1.add(c1.get(i));
            list2.add(c2.get(i));
        }

        return sameCharacter(list1, list2);

    }

    private static boolean sameCharacter(List list1, List list2) {
        list1.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1.toString().compareTo(o2.toString()) > 0) {
                    return 1;
                } else if (o1.toString().compareTo(o2.toString()) < 0) {
                    return -1;
                }
                return 0;
            }

        });

        list2.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1.toString().compareTo(o2.toString()) > 0) {
                    return 1;
                } else if (o1.toString().compareTo(o2.toString()) < 0) {
                    return -1;
                }
                return 0;
            }
        });
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < list1.size(); i++) {
            builder1.append(list1.get(i));
        }
        for (int i = 0; i < list2.size(); i++) {
            builder2.append(list2.get(i));
        }
        return builder1.toString().equals(builder2.toString());
    }
}
