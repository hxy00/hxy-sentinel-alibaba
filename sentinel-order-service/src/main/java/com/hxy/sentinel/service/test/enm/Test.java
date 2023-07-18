package com.hxy.sentinel.service.test.enm;

import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String, Object> mapData = EnumLevel.valueOf("LEVEL3").doSomething();
        System.out.println("mapData = " + mapData);
    }
}
