package com.aspire.caoqiwen.hash;


/**
 * 宝石与石头
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 */
public class NumJewelsInStones {

    public static void main(String[] args) {
        System.out.println("hello world");
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

    public static int numJewelsInStones(String J, String S) {
        int num = 0;
        char[] chars = J.toCharArray();
        char[] temp = S.toCharArray();
        int a[] = new int[256];
        for (int i = 0; i < temp.length; i++) {
            a[temp[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            num += a[chars[i]];
        }
        return num;
    }
}
