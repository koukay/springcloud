package com.houkai.apilistenorder.listen.response;

import lombok.Data;

/**
 * @author yueyi2019
 */
@Data
public class PreGrabResponse {

    private int orderId;

    private String startAddress;

    private String endAddress;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }
}
