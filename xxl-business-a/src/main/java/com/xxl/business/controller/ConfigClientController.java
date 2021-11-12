package com.xxl.business.controller;

import com.xxl.business.domain.CommonResult;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

//    @Value("${xxl.bus.app}")
//    @Value("${xxl.bus.name}")
    private String appName;


    /**
     * INSERT INTO `xxl_spring_config_db`.`config` (`id`, `application`, `profile`, `label`, `item`, `value`, `type`, `favorite`)
     * VALUES ('4', 'xxl-business-a', 'development', 'master', 'xxl.bus.app', 'bbb', '0', '0');
     */
    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return appName;
    }

    @GetMapping("/hello")
    public CommonResult hello() {
        return new CommonResult("hello business-a");
    }
}
