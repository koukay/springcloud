package com.houkai.jmsproduce.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMQConfig {
    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("ActiveMQQueue");
    }
    @Bean
    public Topic topic(){
        return new ActiveMQTempTopic("ActiveMQQueue");
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        return new ActiveMQConnectionFactory(brokerUrl);
    }

    /**
     * Queue模式连接注入
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

    /**
     * Queue模式连接注入
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //设置为发布订阅方式,默认情况下使用的生产消费者方式
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

}
