package com.cloud.service;

import cn.hutool.json.JSONObject;
import com.cloud.entity.Payment;
import com.cloud.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author wangxl
 * @date 2021/7/29 21:04
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/list")
    Result<List<Payment>> list();

    @PostMapping("/payment/add")
    Result<Void> add(@RequestBody Payment payment);

    @GetMapping("/payment/discovery")
    Result<JSONObject> discovery();

    @GetMapping("/payment/timeout")
    Result<String> timeout();
}
