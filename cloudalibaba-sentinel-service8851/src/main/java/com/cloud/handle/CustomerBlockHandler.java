package com.cloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author wangxl
 * @date 2021/8/8 13:07
 */
public class CustomerBlockHandler {

    public static String blockHandler1(BlockException e) {
        return "限流统一处理 blockHandler1";
    }

    public static String blockHandler2(String key,BlockException e) {
        return "限流统一处理 blockHandler2";
    }
}
