package com.houkai.valuation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceValuationCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceValuationCodeApplication.class, args);
    }

}
