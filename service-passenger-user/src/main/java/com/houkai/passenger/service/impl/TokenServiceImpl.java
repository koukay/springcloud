package com.houkai.passenger.service.impl;

import com.houkai.common.utils.JwtUtil;
import com.houkai.passenger.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class TokenServiceImpl implements TokenService {
    /**
     * 生成token
     * @param sunject
     * @return
     */
    @Override
    public String createToken(String sunject) {
        String token = JwtUtil.createToken(sunject, new Date());
        //存缓存，设置过期时间
        return token;
    }
}
