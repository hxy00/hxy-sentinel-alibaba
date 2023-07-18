package com.hxy.sentinel.service.test.strategy.impl;

import com.hxy.sentinel.service.test.strategy.IStrategy;

public class BlackEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
