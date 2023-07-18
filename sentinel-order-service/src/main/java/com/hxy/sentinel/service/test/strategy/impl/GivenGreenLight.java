package com.hxy.sentinel.service.test.strategy.impl;

import com.hxy.sentinel.service.test.strategy.IStrategy;

public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯，放行");
    }
}
