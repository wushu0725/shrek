package com.shrek.nacos.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.shrek.nacos")
public class ShrekAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run( ShrekAuthApplication.class, args );
    }

}
