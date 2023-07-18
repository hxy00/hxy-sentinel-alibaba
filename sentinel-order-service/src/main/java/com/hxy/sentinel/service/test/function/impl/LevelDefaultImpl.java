package com.hxy.sentinel.service.test.function.impl;

import com.hxy.sentinel.service.test.function.IFunction;

import java.util.HashMap;
import java.util.Map;

public class LevelDefaultImpl implements IFunction {
    @Override
    public Map<String, Object> invoke() {
        Map<String, Object> map = new HashMap<>();
        System.out.println("LevelDefault, doSomething");
        map.put("level", "LevelDefault, doSomething");
        return map;
    }
}
