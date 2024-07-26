package org.example.springbootdemo5.demos.service.rocketmq;

import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import java.util.List;

/**
* @Auther: ZhangShenao
* @Date: 2018/9/11 17:36
* @Description: 自定义MessageQueueSelector，根据发送消息时传递的参数，选择指定的MessageQueue
*/
public class OrderMessageQueueSelector implements MessageQueueSelector{
   @Override
   public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
       //选择以参数arg为索引的MessageQueue
       Integer id = (Integer) arg;
       int index = id % mqs.size();
       return mqs.get(index);
   }
}