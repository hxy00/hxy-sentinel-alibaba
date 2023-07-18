package com.hxy.sentinel.service.mq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "miaosha4Topic", consumerGroup = "miaosha-consumer-group4")
@Slf4j
public class RocketmqMiaoshaListener implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        String msg = new String(message.getBody());
        log.info("msg = {}", msg);
    }

}
