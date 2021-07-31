package com.cloud.service;

import com.cloud.vo.Result;
import org.springframework.stereotype.Service;

/**
 * @author wangxl
 * @date 2021/7/31 10:03
 */
@Service
public class PaymentFallBackImpl implements PaymentFeignService {
    @Override
    public Result<String> success(String id) {
        return new Result<>(201, "error", "PaymentFallBackImpl - success 服务降级 id:" + id);
    }

    @Override
    public Result<String> timeout(String id) {
        return new Result<>(201, "error", "PaymentFallBackImpl - timeout 服务降级 id:" + id);
    }
}
