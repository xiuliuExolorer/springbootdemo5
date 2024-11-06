package org.example.springbootdemo5.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class SynTest2 {

    public SynTest2(){
        System.out.println("synTest2 执行了构造方法");
    }

    public void method2(){
        log.info("lalala");
    }

    public static void main(String[] args) {

        SynTest2 synTest2 = new SynTest2();
        Thread thread = new Thread(() -> synTest2.save("清华"));
        Thread thread1 = new Thread(() -> synTest2.save("清华"));
        Thread thread2 = new Thread(() -> synTest2.save("北大"));


    }

    ConcurrentHashMap<String,Integer> schoolMap = new ConcurrentHashMap<>();

    public void save(String key){
        if(StringUtils.isNoneBlank(key)&&
                schoolMap.contains(key)){
            schoolMap.put(key ,schoolMap.get(key)+1);
            log.info("value:{}",schoolMap.get(key)+1);
//            schoolMap.computeIfPresent()
        }
    }

    @Test
    void test1(){
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        String s = new String("a");
        map1.put("a",s);
        map2.put("a",s);
        System.out.println(map1.get("a")==map2.get("a"));
        CompletableFuture<Object> objectCompletableFuture = new CompletableFuture<>();
//        Executors.newFixedThreadPool(10).submit()
    }
}
