package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.handle.CustomerBlockHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxl
 * @date 2021/8/8 9:37
 */
@RestController
@Api(tags = "流量卫兵 API 文档")
public class SentinelController {

    @ApiOperation("QPS 测试")
    @GetMapping("/qpsTest")
    public String qpsTest() {
        String name = Thread.currentThread().getName();
        return "thread：" + name + " ------------- qpsTest ------------- ";
    }

    @ApiOperation("线程数测试")
    @GetMapping("/threadTest")
    public String threadTest() {
        String name = "";
        try {
            name = Thread.currentThread().getName();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "thread：" + name + " ------------- threadTest------------- ";
    }

    /**
     * value 唯一值
     * blockHandlerClass 处理限流的类
     * blockHandler 处理限流的兜底方法
     *
     * @param key
     * @return
     */
    @ApiOperation("热点测试")
    @GetMapping("/hotKeyTest")
    @SentinelResource(value = "hotKeyTest",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "blockHandler2")
    public String hotKeyTest(String key) {
        return " -------------- hotKeyTest key = " + key + " -------------- ";
    }

    public String hotKeyFallBack(String key, BlockException e) {
        return " -------------- hotKeyFallBack key = " + key + "!!! -------------- ";
    }
}
