package org.example.springbootdemo5.demos.service.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@Slf4j
public class RocketMqProducerConfig {

    @Autowired
    private RaftMqProducerProperties mqProperties;

    @Bean("mqProducer")
    public DefaultMQProducer getRaftProducer() throws Exception{
        if (StringUtils.isEmpty(mqProperties.getProducerGroupName())) {
            throw new RuntimeException("请在配置文件中指定消息发送方group！");
        }
        DefaultMQProducer producer = new DefaultMQProducer(mqProperties.getProducerGroupName());
        log.info("nameServer {}",mqProperties.getNameServer());
        producer.setNamesrvAddr(mqProperties.getNameServer());
        producer.setRetryTimesWhenSendFailed(mqProperties.getProducerRetry());
        producer.setRetryTimesWhenSendAsyncFailed(mqProperties.getProducerRetry());
        producer.setSendMsgTimeout(mqProperties.getProducerTimeout());
        producer.setCompressMsgBodyOverHowmuch(4096);
        producer.setMaxMessageSize(mqProperties.getMaxMessageSize());
        producer.setRetryAnotherBrokerWhenNotStoreOK(false);
        producer.setVipChannelEnabled(false);
        producer.setSendMsgTimeout(30000);
        producer.setDefaultTopicQueueNums(mqProperties.getQueueSize());
        producer.start();
        return producer;
    }

}
