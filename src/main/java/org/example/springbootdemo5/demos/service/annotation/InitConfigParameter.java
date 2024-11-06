package org.example.springbootdemo5.demos.service.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Slf4j
@Component
public class InitConfigParameter {


    @Resource
    private RedisTemplate redisTemplate;
 
    @PostConstruct
    public void init() throws Exception {
        // 将数据库中的参数加载到哈希表中
        redisTemplate.opsForValue().set("1","1");
        System.out.println(redisTemplate.opsForValue().get("1"));
//        List<ItpcsConfig> RuleResultSet = itpcsConfigMapper.selectAll();
//        log.info(LogUtil.marker(RuleResultSet), "init propertyMap");
//        RuleResultSet.forEach(itpcsConfig -> PropertyMap.add(itpcsConfig.getName(), itpcsConfig.getValue()));
    }
}
