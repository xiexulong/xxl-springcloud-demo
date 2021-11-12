package com.xxl.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;


/**
 RequestRateLimiter 过滤器可以用于限流，使用RateLimiter实现来确定是否允许当前请求继续进行，
    如果请求太大默认会返回HTTP 429-太多请求状态。
 添加限流策略的配置类，这里有两种策略
        一种是根据请求参数中的username进行限流，
        另一种是根据访问IP进行限流；
 */
@Configuration
public class RedisRateLimiterConfig {
//    @Bean
//    KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
//    }

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
