package com.brianway.learning.java.base.quartz;

/**
 * job具体操作类
 */
public class SpringJob implements LiteJob {

    @Override
    public void execute() {
        System.out.println("hello quartz");
    }
}
