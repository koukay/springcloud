package com.houkai.jmsproduce.service;


import javax.jms.Destination;

public interface ProduceService {
    /**
     * 向指定队列发送消息
     * @param destination
     * @param message
     */
    public void send(Destination destination,String message);

}
