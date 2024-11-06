package org.example.springbootdemo5.demos.service.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.selector.SelectMessageQueueByHash;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MqProducerTest1 {



    private static String a;
    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producerGroup = new DefaultMQProducer("producerGroup");
        producerGroup.setNamesrvAddr("localhost:9876");
        producerGroup.setSendMsgTimeout(30000);
        producerGroup.setMaxMessageSize(409600);
        producerGroup.setRetryTimesWhenSendFailed(3);
        producerGroup.setCompressMsgBodyOverHowmuch(4096);
        producerGroup.setRetryAnotherBrokerWhenNotStoreOK(false);
        producerGroup.setVipChannelEnabled(false);
        producerGroup.setSendMsgTimeout(30000);
//        producerGroup.setDefaultTopicQueueNums(mqProperties.getQueueSize());
        producerGroup.start();

        Message message = new Message("mingTopic5", "TagA", (System.currentTimeMillis()+"苹果手机大降价了").getBytes(RemotingHelper.DEFAULT_CHARSET));
        message.setDelayTimeLevel(2);
        producerGroup.send(message,new SelectMessageQueueByHash(),1);
        Executors.newFixedThreadPool(1);
        System.out.println("producer send msg ： "+new String(message.getBody()));

        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }


}
