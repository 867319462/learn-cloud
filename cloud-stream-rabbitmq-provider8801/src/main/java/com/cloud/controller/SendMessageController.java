package com.cloud.controller;

import com.cloud.service.IMessageProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2021/8/4 20:32
 */
@Api(tags = "Stream API 文档")
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @ApiOperation("发送消息")
    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
