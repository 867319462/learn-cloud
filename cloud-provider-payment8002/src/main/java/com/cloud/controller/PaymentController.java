package com.cloud.controller;


import com.cloud.entity.Payment;
import com.cloud.service.IPaymentService;
import com.cloud.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("查询所有支付信息")
    @GetMapping("/list")
    public Result<List<Payment>> list() {
        List<Payment> list = paymentService.list();

        log.info("serverPort:{}",serverPort);

        return new Result<>(200, "OK，serverPort：" + serverPort, list);
    }

    @ApiOperation("添加支付信息")
    @PostMapping("/add")
    public Result<Void> add(@RequestBody Payment payment) {
        boolean save = paymentService.save(payment);

        log.info("serverPort:{}",serverPort);

        return save ? new Result<>(200, "OK，serverPort：" + serverPort) : new Result<>(201, "FAIL");
    }
}
