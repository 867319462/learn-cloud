package com.cloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
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
public class NacosController {

    @Value("${server.port}")
    private String serverPort;

    @ApiOperation("获取服务端口号")
    @GetMapping("/port")
    public String port() {
        return "本服务端口为：" + serverPort;
    }

    @ApiOperation("回调测试")
    @GetMapping("/fallbackTest")
    public String fallbackTest(int key) {
        if (key == 10) {
            throw new RuntimeException("端口号：" + serverPort + " 错了！！！！！");
        }
        return "本服务端口为：" + serverPort;
    }
}
