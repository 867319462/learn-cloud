package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 订单启动类
 *
 * @author wangxl
 * @date 2021/7/25 16:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderApplication80.class, args);
    }

}
