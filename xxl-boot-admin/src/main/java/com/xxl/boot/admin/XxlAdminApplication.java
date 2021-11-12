package com.xxl.boot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 界面：http://localhost:9301
 */
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class XxlAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlAdminApplication.class, args);
    }

}
