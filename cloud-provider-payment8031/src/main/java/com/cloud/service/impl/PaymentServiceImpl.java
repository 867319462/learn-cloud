package com.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.entity.Payment;
import com.cloud.mapper.PaymentMapper;
import com.cloud.service.IPaymentService;
import org.springframework.stereotype.Service;

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

    @Override
    public String paymentTimeOut(String id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "\t paymentTimeOut \t id:" + id + "\t success!!!";
    }
}
