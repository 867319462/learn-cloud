package com.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.cloud.service.PaymentFeignService;
import com.cloud.vo.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxl
 * @date 2021/7/25 17:11
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单 API 文档")
//@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @ApiOperation("测试正常方法")
    @GetMapping("/success")
    public Result<String> success(@RequestParam("id") String id) {
        return paymentFeignService.success(id);
    }

    @ApiOperation("测试超时方法")
    @GetMapping("/timeout")
    //@HystrixCommand(fallbackMethod = "timeOutFallBack", commandProperties = {
    //        // 超时时间
    //        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    //})
    //@HystrixCommand
    public Result<String> timeout(@RequestParam("id") String id) {
        return paymentFeignService.timeout(id);
    }

    @ApiOperation("测试服务熔断")
    @GetMapping("/timeout")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallBack", commandProperties = {
            // 是否打开断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public Result<String> paymentCircuitBreaker(@RequestParam("id") String id) {
        if ("-1".equals(id)) {
            throw new RuntimeException();
        }
        String uuid = IdUtil.simpleUUID();
        return new Result<>(200, "ok", "线程：" + Thread.currentThread().getName() + " uuid：" + uuid);
    }

    public Result<String> timeOutFallBack(String id) {
        return new Result<>(201, "error", "timeOutFallBack 服务降级 id:" + id);
    }

    public Result<String> globalFallBack() {
        return new Result<>(201, "error", "全局服务降级！！");
    }
}