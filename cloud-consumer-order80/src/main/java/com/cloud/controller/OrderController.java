package com.cloud.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.cloud.entity.Payment;
import com.cloud.lb.MyLoadBalance;
import com.cloud.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangxl
 * @date 2021/7/25 17:11
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单 API 文档")
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MyLoadBalance myLoadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @ApiOperation("发现信息")
    @GetMapping("/payment/discovery")
    public Result discovery() {
        return restTemplate.getForObject(PAYMENT_URL + "/discovery", Result.class);
    }

    @ApiOperation("调用支付服务增加接口 - loadBalance")
    @PostMapping("/payment/add1")
    public Result add1(@RequestBody Payment payment) {
        return restTemplate.postForEntity(getPaymentUrl() + "/payment/add", payment, Result.class).getBody();
    }

    @ApiOperation("调用支付服务查询接口 - loadBalance")
    @GetMapping("/payment/list1")
    public Result list1() {
        return restTemplate.getForObject(getPaymentUrl() + "/payment/list", Result.class);
    }

    @ApiOperation("发现信息 - loadBalance")
    @GetMapping("/payment/discovery1")
    public Result discovery1() {
        return restTemplate.getForObject(getPaymentUrl() + "/payment/discovery", Result.class);
    }

    /**
     * 获取支付 uri
     *
     * @return uri
     */
    private String getPaymentUrl() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (CollectionUtil.isEmpty(instances)) {
            return "没有存活的实例";
        }

        ServiceInstance instance = myLoadBalance.instances(instances);
        return instance.getUri().toString();
    }
}