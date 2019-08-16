package com.aspire.caoqiwen.recursive;


import java.util.HashMap;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 采用缓存
 */
public class Fib {


    private static final HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        System.out.println("hello world");
        int result = fib(3);
        System.out.println(result);

    }

    public static int fib(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        int result;
        if (N < 2) {
            result = N;
        } else {
            result = fib(N - 1) + fib(N - 2);
        }
        cache.put(N, result);
        return result;
    }


}
