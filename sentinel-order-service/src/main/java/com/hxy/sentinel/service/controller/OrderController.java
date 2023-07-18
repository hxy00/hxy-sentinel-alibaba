package com.hxy.sentinel.service.controller;

import com.alibaba.fastjson.JSON;
import com.hxy.sentinel.service.client.ICustomerService;
import com.hxy.sentinel.service.entity.OrderInfo;
import com.hxy.sentinel.service.mq.IMessageService;
import com.hxy.sentinel.service.test.enm.EnumLevel;
import com.hxy.sentinel.service.test.function.IFunction;
import com.hxy.sentinel.service.test.function.IfFunction;
import com.hxy.sentinel.service.test.function.impl.Level1Impl;
import com.hxy.sentinel.service.test.function.impl.Level2Impl;
import com.hxy.sentinel.service.test.function.impl.Level3Impl;
import com.hxy.sentinel.service.test.function.impl.LevelDefaultImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private ICustomerService iCustomerService;

    @Resource
    private IMessageService iMessageService;

    @GetMapping("/create")
    public String create() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo("O2023050517350001");
        orderInfo.setOrderAmt(new BigDecimal(1200));
        String result = iCustomerService.orderNotify(orderInfo);
        System.out.println("result = " + result);
        return result;
    }

    @GetMapping("/mqTest")
    public String mqTest() {
        iMessageService.sendMessage("order");
        return "";
    }

    @GetMapping("/enumTest")
    public String enumTest(@RequestParam("level") String level) {
        Map<String, Object> mapData = EnumLevel.valueOf(level).doSomething();
        System.out.println("mapData = " + mapData);
        return JSON.toJSONString(mapData);
    }

    @GetMapping("/funTest")
    public String funTest(@RequestParam("level") String level) {
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
        Map<String, Object> mapData = ifFunction.doIf(level);
        System.out.println("mapData = " + mapData);
        return JSON.toJSONString(mapData);
    }
}
