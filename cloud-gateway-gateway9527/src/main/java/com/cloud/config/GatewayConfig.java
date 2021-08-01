package com.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangxl
 * @date 2021/8/1 9:44
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator globalConfig(RouteLocatorBuilder route) {
        RouteLocatorBuilder.Builder routes = route.routes();

        routes.route("baidu",
                predicateSpec -> predicateSpec.path("/baidu/**")
                        .uri("https://www.baidu.com/**"));

        return routes.build();
    }
}
