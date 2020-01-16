package com.houkai.sms.service;

import com.houkai.common.dto.sms.SmsSendRequest;

public interface AliService {

    /**
     * 发送短信
     * @param smsSendRequest
     * @return
     */
    public int senSms(SmsSendRequest smsSendRequest);
}
