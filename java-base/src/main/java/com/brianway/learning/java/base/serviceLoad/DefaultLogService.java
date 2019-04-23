package com.brianway.learning.java.base.serviceLoad;

public class DefaultLogService implements LogService {
    @Override
    public void log(String msg) {
        System.out.println(msg);
    }
}
