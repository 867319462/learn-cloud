package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单启动类
 *
 * @author wangxl
 * @date 2021/7/25 16:51
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrderApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApplication80.class, args);
    }

}
