package com.houkai.apipassenger.service.impl;

import com.houkai.apipassenger.service.VerificationCodeService;
import com.houkai.common.constant.IdentityConstant;
import com.houkai.common.dto.ResponseResult;
import com.houkai.common.dto.verificationcode.VerifyCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.annotation.Resource;
/**
 * @author yueyi2019
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

	@Autowired
	private RestTemplate restTemplate;
	
	private final String SERVICE_VERIFICATION_CODE_SERVICE = "service-verification-code";
	
	@Override
	public String getCode(String phoneNumber) {
		String url = "http://"+SERVICE_VERIFICATION_CODE_SERVICE+"/verify-code/generate/"+ IdentityConstant.PASSENGER+ "/" +phoneNumber;
		ResponseResult result = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<Object>(null,null),ResponseResult.class).getBody();

		if(result.getCode()==1) {
			JSONObject data = JSONObject.fromObject(result.getData().toString());
			VerifyCodeResponse response = (VerifyCodeResponse)JSONObject.toBean(data,VerifyCodeResponse.class);
			return response.getCode();
		}else {
			return "";
		}
	}

	@Override
	public String checkCode(String phoneNumber, String code) {
		return null;
	}

}
