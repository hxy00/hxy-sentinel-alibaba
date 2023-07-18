package com.hxy.sentinel.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.hxy.sentinel.service.client")
public class SentinelOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelOrderServiceApplication.class, args);
    }

}
