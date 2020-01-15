package com.houkai.jmsconsumer.controller;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/receiver")
public class MessageReceiver {
    @GetMapping("/testReceiver")
    public void testReceiver( HttpServletResponse response) throws JMSException, IOException {
//        1.获取连接工厂
        ActiveMQConnectionFactory connectionFactory= new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://localhost:61616"
        );
//        2.获取一个向activemq的连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
//        3.获取session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        4.找到目的地,获取destination
        Destination queue = session.createQueue("HOUKAIQueue");
//        5获取消息
        MessageConsumer consumer = session.createConsumer(queue);
        while (true) {
            TextMessage receive = (TextMessage) consumer.receive();
            System.out.println("message: "+receive.getText());
            response.setContentType("text/json; charset=utf-8");
            response.getWriter().write(receive.toString());
        }

    }

}
