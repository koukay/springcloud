package com.houkai.apipassenger.ribbonconfigscan;

import com.houkai.apipassenger.ribbonconfig.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;


@Configuration
@RibbonClient(name = "service-sms",configuration = RibbonConfiguration.class)
public class TestConfiguration {

}