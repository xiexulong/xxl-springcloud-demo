package com.xxl.ribbon.controller;

import com.xxl.ribbon.domain.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class XxlController {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.xxl-business-b}")
    private String serviceUrl;

    @GetMapping("/hello")
    public CommonResult hello() {
        System.out.println(serviceUrl + "/ribbon");
        return restTemplate.getForObject(serviceUrl + "/ribbon", CommonResult.class);
    }
}
