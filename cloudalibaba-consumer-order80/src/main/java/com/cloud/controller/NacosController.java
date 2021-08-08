package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxl
 * @date 2021/8/5 20:51
 */
@RestController
@Api(tags = "Nacos API 文档")
@RequestMapping("/nacos")
public class NacosController {

    @Value("${server-uri.nacos-user-server}")
    private String serverUri;

    @Resource
    private RestTemplate restTemplate;

    @ApiOperation("获取服务端口号")
    @GetMapping("/getPort")
    public String getPort() {
        return restTemplate.getForObject(serverUri + "/nacos/port", String.class);
    }

    @ApiOperation("回调测试")
    @GetMapping("/fallbackTest")
    @SentinelResource(value = "fallbackTest", fallback = "fallbackHandler")
    public String fallbackTest(int key) {
        if (key == 10) {
            throw new RuntimeException("错了！！！！！");
        }

        Map<String, Object> map = new HashMap<>(16);
        map.put("key", key);

        return restTemplate.getForObject(serverUri + "/nacos/fallbackTest?key={key}", String.class, map);
    }

    public String fallbackHandler(int key, Throwable e) {
        return "key 不能等于 10";
    }
}
