package com.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 应用上下文配置
 *
 * @author wangxl
 * @date 2021/7/25 17:13
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * LoadBalanced 负载均衡
     */
    @Bean
    //@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
