package com.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.entity.Payment;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangxl
 * @since 2021-07-25
 */
public interface IPaymentService extends IService<Payment> {
    String paymentSuccess(String id);

    String paymentTimeOut(String id);

    String paymentError(String id);

    String paymentCircuitBreaker(String id);
}
