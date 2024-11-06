package org.example.springbootdemo5.demos.service.redis.redisson;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("redisson.config")
@Data
public class RedisConfigProperties {
    /**
     * 密码
     */
    private String password;
    /**
     * 连接地址
     */
    private String address;
    /**
     * # 连接空闲超时，单位：毫秒
     */
    private int idleConnectionTimeout;
    /**
     * # 连接超时，单位：毫秒
     */
    private int connectTimeout;
    /**
     * # 命令失败重试次数
     */
    private int retryAttempts;
    /**
     * # 命令重试发送时间间隔，单位：毫秒
     */
    private int retryInterval;

    /**
     * 监控锁的看门狗超时，单位：毫秒
     */
    private int lockWatchdogTimeout;

    /**
     * 默认值: 当前处理核数量 * 2
     *
     * 这个线程池数量被所有RTopic对象监听器，RRemoteService调用者和RExecutorService任务共同共享。
     */
    private int threads;

    /**
     * nettyThreads （Netty线程池数量）
     * 默认值: 当前处理核数量 * 2
     *
     * 这个线程池数量是在一个Redisson实例内，被其创建的所有分布式数据类型和服务，以及底层客户端所一同共享的线程池里保存的线程数量。
     */
    private int nettyThreads;

}