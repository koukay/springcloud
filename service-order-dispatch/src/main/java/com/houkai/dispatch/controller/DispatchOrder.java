package com.houkai.dispatch.controller;

import com.houkai.common.dto.ResponseResult;
import com.houkai.dispatch.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dispatch")
public class DispatchOrder {

    @Autowired
    DispatchService dispatchService;

    @GetMapping("/call/{orderId}")
    public ResponseResult callCar(@PathVariable("orderId") int orderId){
        //测试派给1号司机,选司机的逻辑
        List<Integer> driverList= new ArrayList<>();
        driverList.add(1);
        return dispatchService.dispatch(orderId,driverList);
    }
}
