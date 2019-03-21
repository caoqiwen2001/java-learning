package com.caoqiwen.learning.design.example9;

/**
 * 日记logFilter
 */
public class LogFilter extends  FilterAdapter {

    @Override
    public void init(FilterChain chain, int str) {

        chain.init(str);

        System.out.println("this  logFilter has sucess");

    }
}
