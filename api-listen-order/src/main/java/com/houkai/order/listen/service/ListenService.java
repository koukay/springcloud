package com.houkai.order.listen.service;


import com.houkai.order.listen.response.PreGrabResponse;

/**
 * @author yueyi2019
 */
public interface ListenService {
    /**
     *
     * @param driverId
     * @return
     */
    public PreGrabResponse listen(int driverId);
}
