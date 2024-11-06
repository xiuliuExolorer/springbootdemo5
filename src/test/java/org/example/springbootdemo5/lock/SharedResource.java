package org.example.springbootdemo5.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
    private int value;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    // 读操作
    public int read(CountDownLatch countDownLatch) {
//        lock.readLock().lock();
        try {
            Thread.sleep(1);
            if(value>0){
                System.out.println(" 读取-线程："+" value:"+value);
            }
            countDownLatch.countDown();
            return value; // 读取共享资源
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            lock.readLock().unlock();
        }
    }

    // 写操作
    public void write(int newValue,CountDownLatch countDownLatch) {
//        lock.writeLock().lock();
        lock2.lock();

        try {
            value += newValue; // 写入共享资源
//            System.out.println("写入-当前线程："+"正在写入，value："+value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
//            lock.writeLock().unlock();
            lock2.unlock();
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int n = 20000;
        CountDownLatch countDownLatch = new CountDownLatch(n);
        SharedResource sharedResource = new SharedResource();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //读取
        for (int i = 0; i < n/2; i++) {
            executorService.execute(()->sharedResource.read(countDownLatch));
        }

        //写入
        for (int i = 0; i < n/2; i++) {
            executorService.execute(()->sharedResource.write(1,countDownLatch));
        }
        executorService.shutdown();
        countDownLatch.await();

        System.out.println("结束");

        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.get();
    }

     int anInt = 10;
    SharedResource sharedResource = new SharedResource();
    void method1(){
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();

    }
    void method2(){

    }
}