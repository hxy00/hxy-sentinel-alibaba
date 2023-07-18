package com.hxy.sentinel.service.mq.impl;

import com.hxy.sentinel.service.mq.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageRocketServiceImpl implements IMessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMessage(String msg) {
        String mdg = msg + "88888";
        System.out.println("rocketmq消息开始发送" + msg);
        SendCallback callback = new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("消息发送失败" + throwable.getMessage());
            }
        };
//        rocketMQTemplate.asyncSend("order:tag1", msg, callback);
//        rocketMQTemplate.asyncSend("order:tag2", mdg, callback);
//        rocketMQTemplate.asyncSend("order:tag3", mdg, callback);
//
//        // 发送带key消息
//        Message<String> messageBuilder = MessageBuilder.withPayload("我的带key消息").setHeader(RocketMQHeaders.KEYS, "qwert").build();
//        rocketMQTemplate.send("orderKeyTopic", messageBuilder);

        // 积压测试
//        for (int i = 1001; i <= 2000; i++) {
//            rocketMQTemplate.syncSend("modelTopic", "我的第" + i + "个消息");
//        }

        for (int i = 1; i <= 10000; i++) {
            String message = "我是第 " + i + "个消息";
            rocketMQTemplate.asyncSend("miaosha4Topic", message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("发送成功");
                }

                @Override
                public void onException(Throwable throwable) {
                    log.warn("发送失败， errorMsg: {}", throwable.getMessage());

                }
            });
        }
    }

    @Override
    public String doMessage() {
        return null;
    }

}
