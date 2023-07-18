package com.hxy.sentinel.service.mq.listener;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author linaibo
 * @version 1.0
 * Create by 2022/12/17 13:50
 */
@Component
@RocketMQMessageListener(topic = "orderKeyTopic",
        consumerGroup = "c11-rocket-order"
)
public class RocketmqKeyListener implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt s) {
        System.out.println("RocketmqKeyListener: 接收到发送的消息: " + s);
        System.out.println("RocketmqKeyListener: keys = " + s.getKeys());
        System.out.println("RocketmqKeyListener: keys = " + s.getProperties().get("KEYS"));
        System.out.println("RocketmqKeyListener: " + new String(s.getBody()));
    }
}