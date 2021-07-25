package com.cloud.controller;

import com.cloud.entity.Payment;
import com.cloud.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2021/7/25 17:11
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单 API 文档")
public class OrderController {
    private static final String PAYMENT_URL = "http://localhost:8001/payment";

    @Resource
    private RestTemplate restTemplate;

    @ApiOperation("调用支付服务增加接口")
    @PostMapping("/payment/add")
    public Result add(@RequestBody Payment payment) {
        return restTemplate.postForEntity(PAYMENT_URL + "/add", payment, Result.class).getBody();
    }

    @ApiOperation("调用支付服务查询接口")
    @GetMapping("/payment/list")
    public Result list() {
        return restTemplate.getForObject(PAYMENT_URL + "/list", Result.class);
    }
}