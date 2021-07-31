package com.cloud.service;

import com.cloud.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangxl
 * @date 2021/7/29 21:04
 */
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE", fallback = PaymentFallBackImpl.class)
public interface PaymentFeignService {

    @GetMapping("/payment/success")
    Result<String> success(@RequestParam("id") String id);

    @GetMapping("/payment/timeout")
    Result<String> timeout(@RequestParam("id") String id);
}
