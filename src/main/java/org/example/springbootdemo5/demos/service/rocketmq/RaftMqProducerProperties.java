package org.example.springbootdemo5.demos.service.rocketmq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "upex.rocketmq")
@Data
public class RaftMqProducerProperties {

    private String nameServer = "127.0.0.1:9876";
    private String producerGroupName;
    private String producerTransactionGroupName = "t_producer";
    private Integer producerRetry = 3;
    private Integer maxMessageSize = 409600;
    private Integer producerTimeout = 3000;
    private int queueSize = 256;

    private int sendMqExecutorThreads = 256;
    private int sendMqExecutorQueueSize = 10000;

}