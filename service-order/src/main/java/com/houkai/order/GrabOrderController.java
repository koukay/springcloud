package com.houkai.order;

import com.houkai.order.service.GrabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grab")
public class GrabOrderController{
    @Autowired
    private GrabService grabService;

    @GetMapping("/do/{orderId}/{driverId}")
    public String grab(@PathVariable("orderId") int orderId,@PathVariable("driverId") int driverId){
        grabService.grabOrder(orderId,driverId);
        return "";
    }
}
