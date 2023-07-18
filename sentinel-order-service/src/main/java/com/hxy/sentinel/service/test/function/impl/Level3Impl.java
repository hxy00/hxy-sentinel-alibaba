package com.hxy.sentinel.service.test.function.impl;

import com.hxy.sentinel.service.test.function.IFunction;

import java.util.HashMap;
import java.util.Map;

public class Level3Impl implements IFunction {
    @Override
    public Map<String, Object> invoke() {
        Map<String, Object> map = new HashMap<>();
        System.out.println("Level3, doSomething");
        map.put("level", "Level3, doSomething");
        return map;
    }
}
