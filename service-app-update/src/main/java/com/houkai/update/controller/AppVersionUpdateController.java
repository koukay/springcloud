package com.houkai.update.controller;

import com.houkai.common.dto.ResponseResult;
import com.houkai.common.dto.appUpdate.AppUpdateVersionRequest;
import com.houkai.common.entity.AppVersionUpdate;
import com.houkai.update.service.AppVersionUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app-version")
public class AppVersionUpdateController {
    @Autowired
    private AppVersionUpdateService appVersionUpdateService;

    @PostMapping("/latest")
    public ResponseResult queryLatestAppVersion(@RequestBody AppUpdateVersionRequest appUpdateVersionRequest){
        Integer platformType = appUpdateVersionRequest.getPlatformType();
        Integer appType = appUpdateVersionRequest.getAppType();
        Integer versionCode = appUpdateVersionRequest.getVersionCode();
        List<AppVersionUpdate> appVersionUpdates = appVersionUpdateService.selectByBean(platformType, appType, versionCode);
        return ResponseResult.success(appVersionUpdates);

    }
}
