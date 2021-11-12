package com.xxl.config.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@Validated
@RestController
public class ConfigController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Value("${xxl.bus.app}")
    private String busValue;


    @Autowired
    private Environment env;


    @GetMapping("/hello")
    public void hello() {
//        logger.info("==================={}", busValue);
        String busValue2 = env.getProperty("xxl.bus.name");
        logger.info("==================={}", busValue2);
    }
}
