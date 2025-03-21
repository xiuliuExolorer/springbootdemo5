package org.example.springbootdemo5.demos.service.redis.redisson;

import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;

public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;
    void testRedissonLock(){
        RLock lock = redissonClient.getLock("lock");
        lock.lock();
        lock.unlock();


//        RLock lock1 = redissonClient.getLock();
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(null);

        RLock rLock = readWriteLock.readLock();
//        rLock.();
        rLock.unlock();

    }
    static class A{

    }

}
