package com.houkai.jmsproduce.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者(Topic模式)
 */
@Component
public class ConsumerTopic {

    /**
     * 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
     * @param text
     */
//    @JmsListener(destination = "ActiveMQTopic",containerFactory = "jmsListenerContainerTopic")
    public void receiveQueue(String text){
        System.out.println("消息消費者收到的Topic报文为:" + text);
    }
}
