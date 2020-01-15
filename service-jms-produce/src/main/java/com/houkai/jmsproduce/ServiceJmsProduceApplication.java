package com.houkai.jmsproduce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@EnableEurekaClient
public class ServiceJmsProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceJmsProduceApplication.class, args);
    }

}
