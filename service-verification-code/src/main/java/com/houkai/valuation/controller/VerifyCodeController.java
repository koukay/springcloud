package com.houkai.valuation.controller;

import com.houkai.valuation.service.VerifyCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/verify-code")
public class VerifyCodeController {

    @Autowired
    private VerifyCodeService verifyCodeService;

}
