package com.houkai.passenger.service;

import com.houkai.common.dto.passengeruser.LoginRequest;
import com.houkai.common.entity.PassengerInfo;

public interface PassengerInfoService {
    public PassengerInfo selectByPhoneNumber(String phoneNumber);

    int insertuser(PassengerInfo passengerInfo);
}
