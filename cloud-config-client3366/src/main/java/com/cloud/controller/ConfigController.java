package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefreshScope 动态刷新
 * 需要 POST http://localhost:3355/actuator/refresh 请求一次，进行刷新
 *
 * @author wangxl
 * @date 2021/8/2 21:47
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "config: " + configInfo + " serverPort:" + serverPort;
    }
}
