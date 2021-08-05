package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心启动类
 *
 * @author wangxl
 * @date 2021/8/2 20:05
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3344.class, args);
    }

}
