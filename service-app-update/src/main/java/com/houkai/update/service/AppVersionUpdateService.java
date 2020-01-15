package com.houkai.update.service;

import com.houkai.common.entity.AppVersionUpdate;

import java.util.List;

public interface AppVersionUpdateService {
    List<AppVersionUpdate> selectByBean(Integer platformType, Integer appType, Integer versionCode);
}
