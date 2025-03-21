package org.example.springbootdemo5.demos.service.lock;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {


    @Test
    public void test1() throws InterruptedException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        executorService.execute();
        // 写锁1
        Thread thread1 = new Thread(() -> {
            writeLock.lock();
            System.out.println("thread1 work");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            writeLock.unlock();
        });
        thread1.start();
        Thread.sleep(100);
        // 读锁1
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 start");
            readLock.lock();
            System.out.println("thread2 work");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            readLock.unlock();
        });
        thread2.start();
        Thread.sleep(5000);
        // du锁2
        Thread thread3 = new Thread(() -> {
            System.out.println("thread3 start");
            readLock.lock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread3 lock work");
            readLock.unlock();
        });
        thread3.start();

        // 锁3
        Thread thread4 = new Thread(() -> {
            System.out.println("thread4 start");
            writeLock.lock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread4 lock work");
            writeLock.unlock();
        });
        thread4.start();

        Thread.sleep(4000);
        System.out.println("线程5 开始启动");
        // 4 read lock
        Thread thread5 = new Thread(() -> {
            System.out.println("thread5 start");
            readLock.lock();

            System.out.println("thread5 lock work");
            readLock.unlock();
        });
        thread5.start();

        thread3.join();
        thread2.join();
        thread1.join();
        thread4.join();
        thread5.join();
    }

    @Test
    public void test2(){
        Thread.getAllStackTraces().keySet().forEach(thread -> {
            System.out.println(thread.getName() + " [状态: " + thread.getState() + "]");
        });
        Thread thread = new Thread(() -> System.out.println());
//        thread.setPriority();

        CompletableFuture.runAsync(()-> System.out.println(100));
    }
}
