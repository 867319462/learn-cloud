package com.cloud.controller;


import com.cloud.service.IPaymentService;
import com.cloud.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("测试正常方法")
    @GetMapping("/success")
    public Result<String> success(@RequestParam("id") String id) {
        String s = paymentService.paymentSuccess(id);
        return new Result<>(200, "OK", serverPort + " " + s);
    }

    @ApiOperation("测试超时方法")
    @GetMapping("/timeout")
    public Result<String> timeout(@RequestParam("id") String id) {
        String s = paymentService.paymentTimeOut(id);
        return new Result<>(200, "OK", serverPort + " " + s);
    }
}
