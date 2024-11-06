package org.example.springbootdemo5.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockTest {

    static ReentrantLock reentrantLock = new ReentrantLock(true);
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                try {
                    reentrantLock.lock();

                    CountDownLatch countDownLatch1 = new CountDownLatch(10);
                    countDownLatch1.countDown();
                    Thread.sleep(10000);
                    System.out.println(""+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();


//        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,()-> {
//            System.out.println(11);
//        });
//
//        for (int i = 0; i < 2; i++) {
//            new Thread(()-> {
//                try {
//                    log.info("我是线程{} 正在执行我的任务",Thread.currentThread().getName());
//                    cyclicBarrier.await();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                } catch (BrokenBarrierException e) {
//                    throw new RuntimeException(e);
//                }
//            }).start();
//        }
//
//        reentrantLock.tryLock();
//        reentrantLock.lock();
//        reentrantLock.unlock();
//        ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> 6);
//
//        new Thread(()-> System.out.println(integerThreadLocal.get())).start();


//        reentrantLock.lockInterruptibly();

//        reentrantLock.lockInterruptibly();

//        Thread thread = Thread.currentThread();
//        thread.interrupt();
//
////        wait();
//        SharedResource sharedResource = new SharedResource();
////        sharedResource.wait();
//        sharedResource.notify();
//        int anInt = sharedResource.anInt;


    }


    @Test
    void test3(){
        LockTest lockTest = new LockTest();

        new Thread(lockTest::test1).start();
        new Thread(lockTest::test2).start();
    }

    public synchronized void test1()  {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("等待完成");
    }

    public synchronized void test2(){
        notify();
        System.out.println("唤醒结束");
    }

    CyclicBarrier barrier;
    AtomicInteger integer = new AtomicInteger(0);
    @Test
    void test4() throws InterruptedException, BrokenBarrierException {
        int n = 10;
        barrier = new CyclicBarrier(n,()-> System.out.println("都已经执行完了"+integer.get()));
        for (int i = 0; i < n; i++) {
            new Thread(()-> {
                System.out.println(integer.incrementAndGet());
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();

        }



    }

    @Test
    public void test5(){

    }
}
