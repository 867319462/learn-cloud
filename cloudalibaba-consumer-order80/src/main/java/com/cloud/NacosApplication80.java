package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 消费者启动类
 *
 * @author wangxl
 * @date 2021/8/5 20:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication80.class, args);
    }

}
