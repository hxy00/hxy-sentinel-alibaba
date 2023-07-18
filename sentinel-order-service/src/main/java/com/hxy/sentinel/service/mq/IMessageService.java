package com.hxy.sentinel.service.mq;

public interface IMessageService {
    //发送消息
    public void sendMessage(String msg);

    //接收消息
    public String doMessage();

}
