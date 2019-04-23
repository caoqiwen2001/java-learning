package com.brianway.learning.java.base.guava;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterInGuava {

    /**
     * 限流
     * @param args
     */
    public static void main(String[] args) {
        testRateLimiter();
    }

    public static void testRateLimiter() {

        RateLimiter rateLimiter = RateLimiter.create(5);
        while (true) {
            System.out.println("get 1 tokens:" + rateLimiter.acquire() + "s");
        }
    }
}
