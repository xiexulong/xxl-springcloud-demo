package com.xxl.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class XxlConfigCenterConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlConfigCenterConsulApplication.class, args);
    }

}
