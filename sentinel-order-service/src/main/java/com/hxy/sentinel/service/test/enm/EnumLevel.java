package com.hxy.sentinel.service.test.enm;

import java.util.HashMap;
import java.util.Map;

public enum EnumLevel implements ILevel {
    LEVEL1() {
        @Override
        public Map<String, Object> doSomething() {
            Map<String, Object> mapData = new HashMap<>();
            System.out.println("Level1, doSomething");
            mapData.put("level1", "doSomething");
            return mapData;
        }
    },

    LEVEL2() {
        @Override
        public Map<String, Object> doSomething() {
            Map<String, Object> mapData = new HashMap<>();
            System.out.println("Level2, doSomething");
            mapData.put("Level2", "doSomething");
            return mapData;
        }
    },

    LEVEL3() {
        @Override
        public Map<String, Object> doSomething() {
            Map<String, Object> mapData = new HashMap<>();
            System.out.println("Level3, doSomething");
            mapData.put("Level3", "doSomething");
            return mapData;
        }
    },

}
