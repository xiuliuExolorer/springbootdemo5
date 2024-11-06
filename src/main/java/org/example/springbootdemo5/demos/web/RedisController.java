package org.example.springbootdemo5.demos.web;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 公-众-号：程序员阿牛
 */
@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private RedissonClient redissonClient;

    @RequestMapping("getUser2")
    public String getUserFromRedis(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("A0001");
        userInfo.setUserName("张三丰");
        userInfo.setAddress("武当山");
        redisTemplate.opsForValue().set("userInfo", userInfo);
        // string
        redisTemplate.opsForValue().set("a","b");
        //hash
        redisTemplate.opsForHash().put("s","s1","s2");
        //list
        redisTemplate.opsForList().leftPush("c",0,"a");
        //set
        redisTemplate.opsForSet().add(1,2);

//        redisTemplate.opsForSet().intersectAndStore()
//        redisTemplate.opsForValue().setIfAbsent()
        UserInfo userInfo1 = (UserInfo) redisTemplate.opsForValue().get("userInfo");

        RLock lock = redissonClient.getLock("lock");
        lock.lock();
        lock.unlock();
        return userInfo1.toString();
    }
}