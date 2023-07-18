package com.hxy.sentinel.service.client;

import com.hxy.sentinel.service.entity.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "sentinel-customer-service", path = "/customer")
public interface ICustomerService {

    @PostMapping("/orderNotify")
    String orderNotify(@RequestBody OrderInfo orderInfo);

}
