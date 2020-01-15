package com.houkai.update.service.impl;

import com.houkai.common.entity.AppVersionUpdate;
import com.houkai.update.service.AppVersionUpdateService;
import com.houkai.update.dao.AppVersionUpdateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppVersionUpdateServiceImpl implements AppVersionUpdateService {

    @Autowired
    private AppVersionUpdateMapper appVersionUpdateMapper;
    @Override
    public List<AppVersionUpdate> selectByBean(Integer platformType, Integer appType, Integer versionCode) {
        AppVersionUpdate record= new AppVersionUpdate();
        record.setPlatformType(platformType);
        record.setAppType(appType);
        record.setVersionCode(versionCode);


        return appVersionUpdateMapper.selectByBean(record);
    }
}
