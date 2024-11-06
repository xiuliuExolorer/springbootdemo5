package org.example.springbootdemo5.demos.service.redis.redisson;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
public class RedissonConfig {
    @Autowired
    private RedisConfigProperties properties;

    @Bean
    @Qualifier
    public RedissonClient redissonClient()  {

        Config config = new Config();
        config.useSingleServer().setAddress(properties.getAddress())
                .setIdleConnectionTimeout(properties.getIdleConnectionTimeout())
                .setTimeout(properties.getConnectTimeout())
                .setRetryAttempts(properties.getRetryAttempts())
                .setRetryInterval(properties.getRetryInterval());
        config.setLockWatchdogTimeout(properties.getLockWatchdogTimeout());
        config.setThreads(properties.getThreads());
        config.setNettyThreads(properties.getNettyThreads());
        if(!StringUtils.isEmpty(properties.getPassword())){
            config.useSingleServer().setPassword(properties.getPassword());//设置密码
        }
        return  Redisson.create(config);

    }
}