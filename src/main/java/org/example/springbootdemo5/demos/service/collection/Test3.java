package org.example.springbootdemo5.demos.service.collection;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test3
{
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(()-> {
            try {
                synchronized (a){
                    a.wait();
                    System.out.println("1 i woke up");
                    countDownLatch.countDown();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                synchronized (a){
                    a.wait();
                    System.out.println("2 i woke up");
                    countDownLatch.countDown();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{
            synchronized (a){
                a.notifyAll();
                System.out.println("开始 notify了");
            }
        }).start();
        countDownLatch.await();


        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        condition.await();
        Thread.yield();
        Thread thread = new Thread(() -> System.out.println());
        thread.setPriority(Thread.MIN_PRIORITY);

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.awaitTermination(100, TimeUnit.SECONDS);

    }
}
