package org.example.springbootdemo5.Strings;

import org.example.springbootdemo5.Test5;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;



public class Class2 extends Test5 {


    private static final Logger log = LoggerFactory.getLogger(Class2.class);

    @Test
    void test2(){
        test1();
        PriorityQueue<Object> objects = new PriorityQueue<>();
        objects.add(1);
        objects.add(3);
        objects.add(2);

        for (Object object : objects) {
            System.out.println(object);
        }
    }


    int anInt = 100;
    @Test
    public void test3() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(anInt);
        for (int i = 0; i < anInt; i++) {
            new Thread(()-> {
                synchronized (this){
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        log.info("消耗时间：{}",(System.currentTimeMillis()-startTime));
    }

    @Test
    public void test4() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(anInt);
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < anInt; i++) {
            new Thread(()-> {
                reentrantLock.lock();
                countDownLatch.countDown();
                reentrantLock.unlock();
            }).start();
        }
        countDownLatch.await();
        log.info("消耗时间：{}",(System.currentTimeMillis()-startTime));

        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
//        objectObjectConcurrentHashMap.put(null,null);
    }
    public void test5(){
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock();
    }


    @Test
    public void test6(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(()-> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
        log.info("关闭了吗，{}",executorService.isShutdown());
    }
}





