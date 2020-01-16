package com.houkai.passenger.controller;

import com.houkai.common.constant.IdentityConstant;
import com.houkai.common.dto.ResponseResult;
import com.houkai.common.dto.passengeruser.LoginRequest;
import com.houkai.common.entity.PassengerInfo;
import com.houkai.passenger.service.PassengerInfoService;
import com.houkai.passenger.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private PassengerInfoService passengerInfoService;

    @Autowired
    private TokenService tokenService;
    @PostMapping("/passenger")
    public ResponseResult passengerLogin(@RequestBody LoginRequest loginRequest){
        String phoneNumber = loginRequest.getPhoneNumber();
        PassengerInfo passengerInfo = passengerInfoService.selectByPhoneNumber(phoneNumber);
        if (passengerInfo==null) {
            passengerInfo=new PassengerInfo();
            //插入用户
            passengerInfo.setPhoneNumber(phoneNumber);
           int in= passengerInfoService.insertuser(passengerInfo);
        }{
            //更新最后登录时间
        }
        int passengerId=1;
        //生成通过jwt 生成 token，以后需要登录认证的接口，都需要带上token，还有签名规则
        String subject = IdentityConstant.PASSENGER + "_" + phoneNumber + "_" + passengerId;
        String token = tokenService.createToken(subject);
        return ResponseResult.success(token);
    }

}
