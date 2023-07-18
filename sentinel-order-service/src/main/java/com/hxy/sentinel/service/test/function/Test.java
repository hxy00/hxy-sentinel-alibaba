package com.hxy.sentinel.service.test.function;

import com.hxy.sentinel.service.test.function.impl.Level1Impl;
import com.hxy.sentinel.service.test.function.impl.Level2Impl;
import com.hxy.sentinel.service.test.function.impl.Level3Impl;
import com.hxy.sentinel.service.test.function.impl.LevelDefaultImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 */
public class Test {

    public static void main(String[] args) {
        IfFunction<String> ifFunction = new IfFunction<>(new HashMap<>());

        //定义好要判断的条件和对应执行的方法
        ifFunction.add("1", () -> {
            IFunction iFunction = new Level1Impl();
            return iFunction.invoke();
        }).add("2", () -> {
            IFunction iFunction = new Level2Impl();
            return iFunction.invoke();
        }).add("3", () -> {
            IFunction iFunction = new Level3Impl();
            return iFunction.invoke();
        }).add("4", () -> {
            IFunction iFunction = new LevelDefaultImpl();
            return iFunction.invoke();
        });

        // 要进入的条件
        Map<String, Object> mapData = ifFunction.doIf("4");
        System.out.println("mapData = " + mapData);

    }
}