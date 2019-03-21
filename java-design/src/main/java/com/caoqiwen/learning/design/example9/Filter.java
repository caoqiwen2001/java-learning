package com.caoqiwen.learning.design.example9;

import java.util.List;

/**
 * 过滤器接口
 */
public interface Filter {

    public void init(FilterChain chain, int str);


}
