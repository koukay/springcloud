package com.houkai.apipassenger.controller;

import com.houkai.apipassenger.dto.ShortMsgRequest;
import com.houkai.apipassenger.service.ShortMsgService;
import com.houkai.apipassenger.service.VerificationCodeService;
import com.houkai.common.constant.CommonStatusEnum;
import com.houkai.common.dto.ResponseResult;
import com.houkai.common.utils.PhoneUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yueyi2019
 */
@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController {
	private static final Logger log= LoggerFactory.getLogger(SmsController.class);
	@Autowired
	private ShortMsgService shortMsgService;
	
	@Autowired
	private VerificationCodeService verificationCodeService;

	/**
	 * 发送验证码
	 * @param shortMsgRequest
	 * @return
	 *
	 * //	@HystrixCommand(fallbackMethod = "sendFail")
	 */
	@PostMapping("/verify-code/send")
	public ResponseResult verifyCodeSend(@RequestBody ShortMsgRequest shortMsgRequest) {
		String phoneNumber = shortMsgRequest.getPhoneNumber();
		//校验手机号
		if(StringUtils.isBlank(phoneNumber)) {
			return ResponseResult.fail(CommonStatusEnum.PHONENUMBER_EMPTY.getCode()	, CommonStatusEnum.PHONENUMBER_EMPTY.getValue());
		}
		Boolean phoneFlag = PhoneUtil.isPhone(phoneNumber);
		if(!phoneFlag) {
			return ResponseResult.fail(CommonStatusEnum.PHONENUMBER_ERROR.getCode()	, CommonStatusEnum.PHONENUMBER_EMPTY.getValue());
		}
		//获取验证码-正常代码
//		String code = verificationCodeService.getCode(phoneNumber);
		String code = "010101";
		log.info("service-verification-code 返回的验证码："+code);
		shortMsgService.send(phoneNumber, code);
		
		return ResponseResult.success(null);
	}
	
	public ResponseResult sendFail(ShortMsgRequest shortMsgRequest) {
		//备用逻辑
		return ResponseResult.fail(-1, "熔断");
	}
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/choseServiceName")
	public ResponseResult choseServiceName() {
		String serviceName = "service-sms";
		ServiceInstance si = loadBalancerClient.choose(serviceName);
		System.out.println("sms节点信息：url:"+si.getHost()+",port:"+si.getPort());
		
		return ResponseResult.success("");
	}
}
