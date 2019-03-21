package com.caoqiwen.learning.design.example9;

/**
 * 配置Fiter
 */
public class ConfigFilter extends FilterAdapter {
    @Override
    public void init(FilterChain chain, int str) {
        chain.init(str);
        System.out.println("this  configFilter has sucess");

    }
}
