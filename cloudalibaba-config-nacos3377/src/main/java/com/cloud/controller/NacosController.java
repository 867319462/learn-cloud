package com.cloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxl
 * @date 2021/8/5 20:51
 */
@RestController
@Api(tags = "Nacos API 文档")
@RequestMapping("/nacos")
@RefreshScope
public class NacosController {

    @Value("${config.info}")
    private String configInfo;

    @ApiOperation("获取配置信息")
    @GetMapping("/config/info")
    public String port() {
        return "配置信息为：" + configInfo;
    }
}
