package com.cloud.controller;

import com.cloud.service.PaymentFeignService;
import com.cloud.vo.Result;
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
    public Result<String> timeout(@RequestParam("id") String id) {
        return paymentFeignService.timeout(id);
    }
}