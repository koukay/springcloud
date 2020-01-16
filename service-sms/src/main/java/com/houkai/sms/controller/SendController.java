package com.houkai.sms.controller;

import com.houkai.common.dto.ResponseResult;
import com.houkai.common.dto.sms.SmsSendRequest;
import com.houkai.sms.service.AliService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/send")
public class SendController {
    @Autowired
    private AliService aliService;


    @RequestMapping(value = "/alisms-template",method = RequestMethod.POST)
    public ResponseResult send(@RequestBody SmsSendRequest smsSendRequest){
        //输出收到的参数内容
        JSONObject param = JSONObject.fromObject(smsSendRequest);
        log.info("/send/alisms-template   request："+param.toString());
        aliService.senSms(smsSendRequest);
        return ResponseResult.success("");
    }
}
