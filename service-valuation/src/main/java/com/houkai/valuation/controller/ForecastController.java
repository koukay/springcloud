package com.houkai.valuation.controller;

import com.houkai.common.dto.ResponseResult;
import com.houkai.common.dto.order.ForecastRequest;
import com.houkai.common.dto.order.ForecastResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/forecast")
public class ForecastController {
    @Value("${server.port}")
    private String port;

    @PostMapping("/single")
    public ResponseResult forecast(@RequestBody ForecastRequest forecastRequest){
        JSONObject requestJson = JSONObject.fromObject(forecastRequest);
        log.info("计价参数："+port+" "+requestJson);
        ForecastResponse forecastResponse= new ForecastResponse();
        Double d=5.2;
        forecastResponse.setPrice(d);
        return ResponseResult.success(forecastResponse);

    }

    @GetMapping("/single2")
    public ResponseResult fore(){

        return ResponseResult.success("Hello springboot security");

    }
}
