package com.houkai.apipassenger.feign;

import com.houkai.common.dto.ResponseResult;
import com.houkai.common.dto.order.ForecastRequest;
import com.houkai.common.dto.order.ForecastResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * @author yueyi2019
 *
 */
@FeignClient(name = "service-valuation")
public interface ServiceForecast {
	
	@RequestMapping(value = "/forecast/single",method = RequestMethod.POST)
	public ResponseResult<ForecastResponse> forecast(@RequestBody ForecastRequest forecastRequest);
	
}
