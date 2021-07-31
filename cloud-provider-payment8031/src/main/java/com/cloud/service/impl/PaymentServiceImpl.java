package com.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.entity.Payment;
import com.cloud.mapper.PaymentMapper;
import com.cloud.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangxl
 * @since 2021-07-25
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {

    @Override
    public String paymentSuccess(String id) {
        return "线程池：" + Thread.currentThread().getName() + "\t paymentSuccess \t id:" + id + "\t success!!!";
    }

    /**
     * 超过2秒，服务降级
     *
     * @param id id
     * @return 字符串
     */
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @Override
    public String paymentTimeOut(String id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "\t paymentTimeOut \t id:" + id + "\t success!!!";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeOutFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @Override
    public String paymentError(String id) {
        int a = 10 / 0;
        return "线程池：" + Thread.currentThread().getName() + "\t paymentTimeOut \t id:" + id + "\t success!!!";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack", commandProperties = {
            // 是否打开断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(@RequestParam("id") String id) {
        if ("-1".equals(id)) {
            throw new RuntimeException();
        }
        String uuid = IdUtil.simpleUUID();
        return "线程池：" + Thread.currentThread().getName() + " id:" + id + " uuid：" + uuid;
    }

    public String paymentCircuitBreakerFallBack(String id) {
        return "服务器熔断 id" + id;
    }

    public String paymentTimeOutFallBack(String id) {
        return "线程池：" + Thread.currentThread().getName() + "\t paymentTimeOutFallBack \t id:" + id + "\t failed!!!";
    }
}
