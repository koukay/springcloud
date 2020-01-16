package com.houkai.passenger.service.impl;

import com.houkai.common.dto.passengeruser.LoginRequest;
import com.houkai.common.entity.PassengerInfo;
import com.houkai.passenger.mapper.PassengerInfoMapper;
import com.houkai.passenger.service.PassengerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerInfoServiceImpl implements PassengerInfoService {
    @Autowired
    private PassengerInfoMapper passengerInfoMapper;
    @Override
    public PassengerInfo selectByPhoneNumber(String phoneNumber) {
        return passengerInfoMapper.selectByPhoneNumber(phoneNumber);
    }

    @Override
    public int insertuser(PassengerInfo passengerInfo) {
        return passengerInfoMapper.insertSelective(passengerInfo);
    }
}
