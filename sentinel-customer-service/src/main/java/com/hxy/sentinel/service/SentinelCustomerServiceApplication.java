package com.hxy.sentinel.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelCustomerServiceApplication.class, args);
    }

}
