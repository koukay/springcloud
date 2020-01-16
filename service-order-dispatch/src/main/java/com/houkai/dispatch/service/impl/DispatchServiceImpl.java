package com.houkai.dispatch.service.impl;

import com.houkai.common.constant.RedisKeyConstant;
import com.houkai.common.dto.ResponseResult;
import com.houkai.dispatch.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchServiceImpl implements DispatchService {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Override
    public ResponseResult dispatch(int orderId, List<Integer> driverIdList) {
        for (Integer driverId : driverIdList) {
            redisTemplate.opsForValue().setIfAbsent(RedisKeyConstant.DRIVER_LISTEN_ORDER_PRE+driverId,orderId+"");
        }
        return ResponseResult.success("");
    }
}
