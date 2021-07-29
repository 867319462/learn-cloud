package com.cloud.controller;


import cn.hutool.json.JSONObject;
import com.cloud.entity.Payment;
import com.cloud.service.IPaymentService;
import com.cloud.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangxl
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/payment")
@Api(tags = {"支付 API"})
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @ApiOperation("查询所有支付信息")
    @GetMapping("/list")
    public Result<List<Payment>> list() {
        List<Payment> list = paymentService.list();

        log.info("serverPort:{}", serverPort);

        return new Result<>(200, "OK，serverPort：" + serverPort, list);
    }

    @ApiOperation("添加支付信息")
    @PostMapping("/add")
    public Result<Void> add(@RequestBody Payment payment) {
        boolean save = paymentService.save(payment);

        log.info("serverPort:{}", serverPort);

        return save ? new Result<>(200, "OK，serverPort：" + serverPort) : new Result<>(201, "FAIL");
    }

    @ApiOperation("发现信息")
    @GetMapping("/discovery")
    public Result<JSONObject> discovery(){
        JSONObject jsonObject = new JSONObject();

        List<String> services = discoveryClient.getServices();
        int order = discoveryClient.getOrder();
        String description = discoveryClient.description();
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        List<String> instanceList = new ArrayList<>();
        for (ServiceInstance instance : instances) {
            String ins = instance.getServiceId() + "  " + instance.getPort() + "  " + instance.getUri();
            instanceList.add(ins);
        }

        jsonObject.set("services",services);
        jsonObject.set("order",order);
        jsonObject.set("description",description);
        jsonObject.set("instances",instanceList);

        return new Result<>(200, "OK", jsonObject);
    }

    @ApiOperation("测试超时方法")
    @GetMapping("/timeout")
    public Result<String> timeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Result<>(200, "OK", serverPort);
    }
}
