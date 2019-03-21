package com.caoqiwen.learning.design.example9;

import java.util.List;

/**
 *  FilterChain 实现接口
 */
public class FilterChainImpl implements FilterChain {

    private final int filterSize;
    private int pos = 0;
    private final FilterProxy filterProxy;

    public FilterChainImpl(FilterProxy proxy) {
        this.filterProxy = proxy;
        this.filterSize = getFilter().size();

    }

    public List<Filter> getFilter() {
        return filterProxy.getGetProxyFilters();
    }

    private Filter nextFilter() {
        return getFilter().get(pos++);
    }


    @Override
    public void init(int str) {
        if (this.pos < filterSize) {
            nextFilter().init(this, str);
            return;

        }
        return;
    }


}
