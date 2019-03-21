package com.caoqiwen.learning.design.example9;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * 责任链测试
 */
public class TestExample9 extends TestCase {

    private FilterProxy proxy;

    @Override
    protected void setUp() throws Exception {
        proxy = new FilterProxy();
        proxy.getGetProxyFilters().add(new ConfigFilter());
        proxy.getGetProxyFilters().add(new LogFilter());
    }


    public void testFilter() {
        FilterChain filterChain = new FilterChainImpl(proxy);
        filterChain.init(0);
    }

}
