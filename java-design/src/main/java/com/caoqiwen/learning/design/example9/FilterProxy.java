package com.caoqiwen.learning.design.example9;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter代理类，实现添加各种Filter类
 */
public class FilterProxy {

    private List<Filter> getProxyFilters = new ArrayList<Filter>();

    public List<Filter> getGetProxyFilters() {
        return getProxyFilters;
    }

    public void setGetProxyFilters(List<Filter> getProxyFilters) {
        this.getProxyFilters = getProxyFilters;
    }
}
