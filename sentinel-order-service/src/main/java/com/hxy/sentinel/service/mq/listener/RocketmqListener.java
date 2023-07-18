package com.hxy.sentinel.service.mq.listener;

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
@RocketMQMessageListener(topic = "order",
        consumerGroup = "c1-rocket-order",
        selectorType = SelectorType.TAG,
        selectorExpression = "tag1"
)
public class RocketmqListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("RocketmqListener: 接收到发送的消息: " + s);

    }
}