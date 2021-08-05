package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 生产者启动类
 *
 * @author wangxl
 * @date 2021/8/5 20:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosApplication9002 {

    public static void main(String[] args) {
        SpringApplication.run(NacosApplication9002.class, args);
    }

}
