package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 支付服务启动类
 * EnableDiscoveryClient 用于当 zookeeper 作为注册中心时注册使用
 * @author wangxl
 * @date 2021/7/25 14:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication8011 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8011.class, args);
    }

}
