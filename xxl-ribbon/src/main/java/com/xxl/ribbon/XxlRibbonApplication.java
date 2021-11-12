package com.xxl.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class XxlRibbonApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(XxlRibbonApplication.class, args);
    }
}
