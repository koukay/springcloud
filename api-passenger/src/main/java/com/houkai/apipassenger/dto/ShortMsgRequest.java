package com.houkai.apipassenger.dto;

import lombok.Data;
/**
 * @author yueyi2019
 */
@Data
public class ShortMsgRequest {
	
	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
