package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 流量卫兵启动类
 *
 * @author wangxl
 * @date 2021/8/5 20:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelApplication8851 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication8851.class, args);
    }

}
