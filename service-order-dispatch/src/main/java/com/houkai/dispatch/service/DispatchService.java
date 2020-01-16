package com.houkai.dispatch.service;

import com.houkai.common.dto.ResponseResult;

import java.util.List;

public interface DispatchService {

    /**
     * 将指定订单拍给多个司机
     * @param orderId
     * @param driverIdList
     * @return
     */
    public ResponseResult dispatch(int orderId, List<Integer> driverIdList);
}
