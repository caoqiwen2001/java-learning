package com.caoqiwen.learning.design.example4;

/**
 * Created by caoqiwen on 2017/12/14.
 */
public class StrategyA implements Strategy {
    @Override
    public void userStrategy() {
        System.out.println("systemA.userStrategy()");
    }
}
