package com.brianway.learning.java.base.serviceLoad;
import org.junit.Test;

import java.util.ServiceLoader;

public class TestServiceLoad {

    @Test
    public void test() {
        ServiceLoader<LogService> services = ServiceLoader.load(LogService.class);
        for (LogService service : services) {
            System.out.println(service.getClass());
            service.log("hello world");
        }
    }
}
