package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka 7002 启动类
 * @author wangxl
 * @date 2021/7/25 22:36
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7002.class, args);
    }

}
