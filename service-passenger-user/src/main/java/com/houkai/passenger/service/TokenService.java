package com.houkai.passenger.service;

public interface TokenService {
    /**
     * 生成token
     * @param sunject
     * @return
     */
    public String createToken(String sunject);
}
