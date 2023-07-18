package com.hxy.sentinel.service.controller;

import com.hxy.sentinel.service.entity.OrderInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/orderNotify")
    public String orderNotify(@RequestBody OrderInfo orderInfo) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(orderInfo);
        return "customer-service: order create success.";
    }

}
