package lettercode01;

import java.util.HashMap;

/**
 * TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 * <p>
 * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 */
public class LetterCode535 {

    private static final HashMap<Integer, Object> map = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("ni hao");

    }


    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {

        int hashCode = longUrl.hashCode();
        map.put(hashCode, longUrl);
        return "http://tinyurl.com/" + hashCode;

    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        int hashCode = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        return (String) map.get(hashCode);
    }
}
