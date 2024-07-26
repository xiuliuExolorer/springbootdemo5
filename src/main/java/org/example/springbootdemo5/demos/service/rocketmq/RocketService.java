package org.example.springbootdemo5.demos.service.rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.selector.SelectMessageQueueByHash;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class RocketService {

    @Autowired
    private DefaultMQProducer mqProducer;

    private static final String[] ORDER_MESSAGES = {"下单","结算","支付","完成"};

    public void sendTest() throws UnsupportedEncodingException, MQBrokerException, RemotingException, InterruptedException, MQClientException {
        System.err.println("Order Message Producer Start...");

        //创建3组消息，每组消息发往同一个Queue，保证消息的局部有序性
        String tags = "Tags";

        OrderMessageQueueSelector orderMessageQueueSelector = new OrderMessageQueueSelector();

        SelectMessageQueueByHash selectMessageQueueByHash = new SelectMessageQueueByHash();

        //注：要实现顺序消费，必须同步发送消息
        for (int i = 0;i < 3;i++){
            String orderId = "" + (i + 1);
            for (int j = 0,size = 10;j < size;j++){
                String message = "Order-" + orderId + "-" + ORDER_MESSAGES[j];
                String keys = message;
                byte[] messageBody = message.getBytes(RemotingHelper.DEFAULT_CHARSET);
                Message mqMsg = new Message("defalut topic", tags, keys, messageBody);
                mqProducer.send(mqMsg, orderMessageQueueSelector,i);
            }
        }

    }


}
