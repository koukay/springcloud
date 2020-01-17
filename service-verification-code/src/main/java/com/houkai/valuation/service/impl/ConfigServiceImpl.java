package com.houkai.valuation.service.impl;

import com.houkai.valuation.service.ConfigService;
import org.springframework.stereotype.Service;

@Service
public class ConfigServiceImpl implements ConfigService {
    private String env1;
    private String env2;
    @Override
    public String getEnv1() {
        env1="env1";
        env2="1";
        return env1;
    }

    @Override
    public String getEnv2() {
        return "env2: "+env2;
    }
}
