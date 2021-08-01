package com.cloud.config;

import cn.hutool.core.util.StrUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.text.DateFormat;

/**
 * 网关过滤器
 *
 * @author wangxl
 * @date 2021/8/1 10:46
 */
@Component
public class GatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println(" -------------------- 进入网关过滤器 ------------------- " + DateFormat.getInstance());
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if (StrUtil.isBlank(name)) {
            System.out.println("请求未携带 name");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
