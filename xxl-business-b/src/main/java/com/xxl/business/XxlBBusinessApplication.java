package com.xxl.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableCircuitBreaker  //开启断路器
@EnableHystrixDashboard //启用监控
@EnableDiscoveryClient
@SpringBootApplication
public class XxlBBusinessApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(XxlBBusinessApplication.class, args);
    }
}
