package com.hxy.sentinel.service.mq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author linaibo
 * @version 1.0
 * Create by 2022/12/17 13:50
 */
@Component
@RocketMQMessageListener(topic = "order", consumerGroup = "c2-rocket-order", selectorType = SelectorType.TAG, selectorExpression = "tag2 || tag3")
@Slf4j
public class RocketmqListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("接收到发送的消息: {}", s);

    }
}