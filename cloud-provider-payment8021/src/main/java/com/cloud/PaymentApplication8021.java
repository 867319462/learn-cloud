package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 支付服务启动类
 *
 * @author wangxl
 * @date 2021/7/25 14:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication8021 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8021.class, args);
    }

}
