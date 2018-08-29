package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Array07 {

    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * <p>
     * 示例:
     * <p>
     * 输入: "the sky is blue",
     * 输出: "blue is sky the".
     * 说明:
     * <p>
     * 无空格字符构成一个单词。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * @param args
     */

    public static void main(String[] args) {
        String s = "";
        String s1 = s.trim();
        String[] cc = s1.split(" ");
        List<String> dd = Arrays.stream(cc).filter(t -> t != null && t.length() != 0).collect(Collectors.toList());

        int i = 0;
        int j = dd.size() - 1;
        while (i < j) {
            String tmp = dd.get(j);
            dd.set(j, dd.get(i));
            dd.set(i, tmp);
            i++;
            j--;
        }
        StringBuilder builder = new StringBuilder();
        for (String sss : dd) {
           System.out.println(sss);
            builder.append(sss);
        }


    }
}
