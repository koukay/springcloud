package com.houkai.jmsconsumer.component;

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

    @JmsListener(destination = "1",containerFactory = "jmsListenerContainerQueue")
    public  void receiveQueue(TextMessage text, Session session) throws JMSException {

        try {
            int i=1/0;
            System.out.println("消費者收到的queue1报文为:"+text.getText());
            //提交完事务后，再确认。
        } catch (Exception e) {
//            session.recover();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("异常了");
        } finally {
            text.acknowledge();
        }
    }
}
