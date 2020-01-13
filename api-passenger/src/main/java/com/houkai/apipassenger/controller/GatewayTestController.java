package com.houkai.apipassenger.controller;


import javax.servlet.http.HttpServletRequest;

import com.houkai.common.dto.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * @author yueyi2019
 */
@Slf4j
@RestController
@RequestMapping("/api-passenger-gateway-test")
public class GatewayTestController {
	private static final Logger log= LoggerFactory.getLogger(GatewayTestController.class);
	@GetMapping("/hello")
	public String helloWorld() {
		log.info("api-passenger-hello");
		return "api-passenger-hello";
	}
	
	@GetMapping("/test-token")
	public ResponseResult send(HttpServletRequest request) {
		
		String token = request.getHeader("token");
		String cookie = request.getHeader("Cookie");
		
		System.out.println("乘客api：token："+token);
		System.out.println("乘客api：cookie："+cookie);
		
		JSONObject result = new JSONObject();
		result.put("api-passenger", "乘客api接口服务");
		
		return ResponseResult.success(result);
	}
	
	
	
	
}
