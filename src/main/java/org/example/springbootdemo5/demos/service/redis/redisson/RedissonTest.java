package org.example.springbootdemo5.demos.service.redis.redisson;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;

public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;
    void testRedissonLock(){
        RLock lock = redissonClient.getLock("lock");
        lock.lock();
        lock.unlock();
    }

}
