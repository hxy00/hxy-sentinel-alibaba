package com.hxy.sentinel.service.mq.listener;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author linaibo
 * @version 1.0
 * Create by 2022/12/17 13:50
 */
@Component
@RocketMQMessageListener(topic = "modelTopic",
        consumerGroup = "model-consumer-group"
)
public class RocketmqModel1Listener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("RocketmqModelListener1: " + s);
    }
}