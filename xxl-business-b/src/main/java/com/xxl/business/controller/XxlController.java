package com.xxl.business.controller;

import com.xxl.business.domain.CommonResult;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class XxlController {

    @GetMapping("/hello")
    public String hello() {
        return "hello xxl business b";
    }

    @GetMapping("/ribbon")
    public CommonResult ribbon() {
        return new CommonResult("test ribbon");
    }
}
