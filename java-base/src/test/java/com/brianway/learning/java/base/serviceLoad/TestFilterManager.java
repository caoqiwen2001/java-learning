package com.brianway.learning.java.base.serviceLoad;

import com.brianway.learning.java.base.loadProperties.FilterManager;
import org.junit.Assert;
import org.junit.Test;

public class TestFilterManager {

    @Test
    public void test() {
        Assert.assertEquals("com.alibaba.druid.filter.logging.Log4jFilter", FilterManager.getFilter("log4j"));

    }
}
