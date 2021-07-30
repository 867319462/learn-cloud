package com.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign 配置
 *
 * @author wangxl
 * @date 2021/7/29 21:41
 */
@Configuration
public class FeignConfig {

    /**
     * 设置 feign 日志输出等级
     *
     * @return 日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
