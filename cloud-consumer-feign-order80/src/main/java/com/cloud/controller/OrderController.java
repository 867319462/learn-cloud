package com.cloud.controller;

import com.cloud.entity.Payment;
import com.cloud.service.PaymentFeignService;
import com.cloud.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("调用支付服务增加接口")
    @PostMapping("/payment/add")
    public Result add(@RequestBody Payment payment) {
        return paymentFeignService.add(payment);
    }

    @ApiOperation("调用支付服务查询接口")
    @GetMapping("/payment/list")
    public Result list() {
        return paymentFeignService.list();
    }

    @ApiOperation("发现信息")
    @GetMapping("/payment/discovery")
    public Result discovery() {
        return paymentFeignService.discovery();
    }

    @ApiOperation("测试超时方法")
    @GetMapping("/payment/timeout")
    public Result<String> timeout(){
        return paymentFeignService.timeout();
    }
}