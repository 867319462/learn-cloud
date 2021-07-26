package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka 7003 启动类
 *
 * @author wangxl
 * @date 2021/7/26 20:30
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication7003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication7003.class, args);
    }

}
