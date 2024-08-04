package org.example.springbootdemo5.demos.service.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;


public class MqProducerTest1 {
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producerGroup = new DefaultMQProducer("producerGroup");
        producerGroup.setNamesrvAddr("localhost:9876");
        producerGroup.setSendMsgTimeout(30000);
        producerGroup.setMaxMessageSize(409600);
        producerGroup.setRetryTimesWhenSendFailed(3);
        producerGroup.start();
        Message message = new Message("mingTopic", "TagA", (System.currentTimeMillis()+"苹果手机大降价了").getBytes(RemotingHelper.DEFAULT_CHARSET));
        producerGroup.send(message);
        System.out.println("producer send msg ： "+new String(message.getBody()));
    }
}
