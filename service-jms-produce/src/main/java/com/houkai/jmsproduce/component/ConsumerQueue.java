package com.houkai.jmsproduce.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 消息消费者(Queue模式)
 */
@Component
public class ConsumerQueue {

    /**
     * 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
     * @param text
     */
//    @JmsListener(destination = "1",containerFactory = "jmsListenerContainerQueue")
    public  void receiveQueue(TextMessage text) throws JMSException {
        System.out.println("消息消费者收到的报文为: "+text);

    }
}
