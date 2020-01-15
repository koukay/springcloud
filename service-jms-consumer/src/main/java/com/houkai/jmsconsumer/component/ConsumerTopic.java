package com.houkai.jmsconsumer.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者(Topic模式)
 */
@Component
public class ConsumerTopic {

    @JmsListener(destination = "ActiveMQTopic",containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic1(String text){
        System.out.println("消息消費者收到的Topic1报文为:" + text);
    }
    @JmsListener(destination = "ActiveMQTopic",containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic2(String text){
        System.out.println("消息消費者收到的Topic2报文为:" + text);
    }
}
