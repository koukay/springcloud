package com.houkai.apilistenorder.listen.service;


import com.houkai.apilistenorder.listen.response.PreGrabResponse;

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
