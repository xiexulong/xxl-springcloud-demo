package com.xxl.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;
    /**
     * http://localhost:9101/configInfo
     *
     * 启动之前需要在配置中心添加配置否则会启动失败
     *key:config/xxl-config-center-consul:dev/data
     *value:config.info: "config info for dev"
     *修改下Consul中的配置信息，再次调用查看配置的接口，就会发现配置已经刷新。
     * Consul使用其自带的Control Bus 实现了一种事件传递机制，从而实现了动态刷新功能。
     */
    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
