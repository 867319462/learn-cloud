package com.cloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.cloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author wangxl
 * @date 2021/8/4 20:25
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        System.out.println("uuid = " + uuid);
        boolean send = output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("send = " + send);
        return "发送成功";
    }
}
