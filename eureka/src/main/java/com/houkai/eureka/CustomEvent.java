package com.houkai.eureka;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEvent {
	
	@EventListener
	public void listen(EurekaInstanceCanceledEvent e) {
		System.out.println(e.getServerId()+"下线事件");
	}
}
