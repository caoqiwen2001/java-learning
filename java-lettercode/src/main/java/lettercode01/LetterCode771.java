package lettercode01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LetterCode771 {


    /**
     * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * <p>
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     *
     * @param args
     */


    public static void main(String[] args) {

        System.out.println("caqwe ");
        String J = "aA";
        String S = "AAABBCCCC";

        System.out.println(baoliSet(S, J));

    }


    public static int count(String J, String S) {
        int sum = 0;
        if (J.length() == 0 || S.length() == 0) return 0;
        for (int i = 0; i < J.length(); i++) {
            Character character = J.charAt(i);
            for (int k = 0; k < S.length(); k++) {
                if (character.equals(S.charAt(k))) {
                    sum++;
                }
            }
        }
        return sum;
    }


    /**
     * 这种速度更快，采用set
     * @param S
     * @param J
     * @return
     */
    public static int baolijiejue(String S, String J) {
        if (S == null || J == null) return 0;
        char[] a = new char[256];
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
        for (int i = 0; i < J.length(); ++i) {
            a[J.charAt(i)]++;
        }
        int ans = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (a[S.charAt(i)] > 0) {
                ans++;
            }
        }
        return ans;
    }

    public static int baoliHashMap(String S, String J) {
        if (S == null || J == null) return 0;
        HashMap<Character, Object> hashMap = new HashMap<>();
        for (int i = 0; i < J.length(); ++i) {
            hashMap.put(J.charAt(i), null);
        }
        int ans = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (hashMap.containsKey(S.charAt(i))) {
                ans++;
            }
        }
        return ans;
    }


    public static int baoliSet(String S, String J) {
        if (S == null || J == null) return 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); ++i) {
            set.add(J.charAt(i));
        }
        int ans = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (set.contains(S.charAt(i))) {
                ans++;
            }
        }
        return ans;
    }
}
