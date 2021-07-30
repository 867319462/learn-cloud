package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单启动类
 *
 * @author wangxl
 * @date 2021/7/25 16:51
 */
@SpringBootApplication
@EnableFeignClients
public class HystrixOrderApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderApplication80.class, args);
    }

}
