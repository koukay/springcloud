package com.houkai.valuation.controller;

import com.houkai.common.dto.ResponseResult;
import com.houkai.common.dto.order.ForecastRequest;
import com.houkai.common.dto.order.ForecastResponse;
import com.houkai.valuation.component.GitConfig;
import com.houkai.valuation.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试获取属性的类
 */
@RefreshScope
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private GitConfig gitConfig;
    @Autowired
    private ConfigService configService;



    @GetMapping("/env")
    public String env(){
       return gitConfig.getEnv();
    }

    @GetMapping("/env1")
    public String env1(){
        return configService.getEnv1();
    }
    @GetMapping("/env2")
    public String env2(){
        return configService.getEnv2();
    }


}
