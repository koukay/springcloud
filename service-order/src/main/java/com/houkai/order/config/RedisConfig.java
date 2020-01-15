package com.houkai.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {
    @Autowired
    RedisSentinelProperties redisSentinelProperties;


}
