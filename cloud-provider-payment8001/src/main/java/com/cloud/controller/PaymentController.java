package com.cloud.controller;


import com.cloud.entity.Payment;
import com.cloud.service.IPaymentService;
import com.cloud.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;

    @ApiOperation("查询所有支付信息")
    @GetMapping("/list")
    public Result<List<Payment>> list() {
        List<Payment> list = paymentService.list();
        return new Result<>(200, "OK", list);
    }

    @PostMapping("/add")
    public Result<Void> add(@RequestBody Payment payment) {
        boolean save = paymentService.save(payment);
        return save ? new Result<>(200, "OK") : new Result<>(201, "FAIL");
    }
}
