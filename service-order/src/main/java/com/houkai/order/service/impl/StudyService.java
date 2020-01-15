package com.houkai.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StudyService {
    public static void main(String[] args) {
        //业务
    }

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    public void grab(String orderId,String driverId){
        String uuid = UUID.randomUUID().toString();
        redisTemplate.opsForValue().setIfAbsent(orderId, uuid);
        //过期时间
        redisTemplate.expire("" , 10, TimeUnit.SECONDS);

        //删除
//        redisTemplate.delete(orderId);
    }
}
