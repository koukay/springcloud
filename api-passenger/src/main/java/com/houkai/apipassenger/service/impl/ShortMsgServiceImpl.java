package com.houkai.apipassenger.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.houkai.apipassenger.service.ShortMsgService;
import com.houkai.apipassenger.service.SmsClient;
import com.houkai.common.dto.ResponseResult;
import com.houkai.common.dto.sms.SmsSendRequest;
import com.houkai.common.dto.sms.SmsTemplateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import net.sf.json.JSONObject;
/**
 * @author yueyi2019
 */
@Service
public class ShortMsgServiceImpl implements ShortMsgService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private SmsClient smsClient;
	
	@Override
	public ResponseResult send(String phoneNumber, String code) {
		System.out.println("手机号和验证码："+phoneNumber+","+code);
		String serviceName = "service-sms";
		String url = "http://"+serviceName+"/send/alisms-template";
		SmsSendRequest smsSendRequest = new SmsSendRequest();
		String[] phoneNumbers = new String[] {phoneNumber};
		smsSendRequest.setReceivers(phoneNumbers);
		
		List<SmsTemplateDto> data = new ArrayList<SmsTemplateDto>();
		SmsTemplateDto dto = new SmsTemplateDto();
		dto.setId("SMS_144145499");
		int templateSize = 1;
		HashMap<String, Object> templateMap = new HashMap<String, Object>(templateSize);
		templateMap.put("code", code);
		dto.setTemplateMap(templateMap);
		data.add(dto);
		
		smsSendRequest.setData(data);
		
		//ribbon调用
//		ResponseEntity<ResponseResult> resultEntity = restTemplate.postForEntity(url, smsSendRequest, ResponseResult.class);
//		ResponseResult result = resultEntity.getBody();
		
		//feign调用
		ResponseResult result = smsClient.sendSms(smsSendRequest);
		
		System.out.println("调用短信服务返回的结果"+JSONObject.fromObject(result));
		return result;
	}

}