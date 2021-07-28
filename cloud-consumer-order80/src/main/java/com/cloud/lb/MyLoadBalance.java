package com.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 我的负载均衡实现类
 *
 * @author wangxl
 * @date 2021/7/28 22:54
 */
@Component
public class MyLoadBalance implements LoadBalance {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取并自增
     *
     * @return 值
     */
    public final int getAndIncrement() {
        int current;
        int next;
        while (true) {
            current = atomicInteger.get();
            next = current < 0 ? 0 : current + 1;
            if (atomicInteger.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
