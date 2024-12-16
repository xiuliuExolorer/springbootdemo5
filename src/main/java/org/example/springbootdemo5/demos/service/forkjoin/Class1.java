package org.example.springbootdemo5.demos.service.forkjoin;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class Class1 {

    @Scheduled(fixedRate = 1000)
//    @Async()
    public void test3() throws InterruptedException {
        System.out.println("1睡眠开始");
        Thread.sleep(30000);
        System.out.println("1睡眠结束");
    }

//    @Scheduled(fixedRate = 1000)
////    @Async()
//    public void test4() throws InterruptedException {
//        System.out.println("2睡眠开始");
//        Thread.sleep(30000);
//        System.out.println("2睡眠结束");
//    }
////    @Scheduled
    @Test
    public void test1() throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        CompletableFuture<Object> objectCompletableFuture = new CompletableFuture<>();
//        CompletableFuture<?> submit = (CompletableFuture<?>) executorService.submit(() -> System.out.println(1));
//        Thread thread = new Thread(System.out::println);
//        Future<?> submit1 = executorService.submit(() -> System.out.println());
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("正在睡眠"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("睡眠结束"+Thread.currentThread().getName());
            countDownLatch.countDown();
        },1,1,TimeUnit.SECONDS);
        countDownLatch.await();

//        retry:
    }

    @Test
    public void test2(){
        A:
        for (int i = 0; i < 5; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                if(i1==2){
                    System.out.println("重新循环：i"+i);
                    break A;
                }
            }
        }
    }

    volatile int a = 0;
    @Test
    public void test4() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Class1 class1 = new Class1();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                if(a<20){
                    synchronized (class1){
                        System.out.println("线程1开始执行"+(++a)+Thread.currentThread().getName());
                        try {
                            class1.notify();
                            class1.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                if(a<20){
                    synchronized (class1){
                        System.out.println("线程2开始执行"+(++a)+Thread.currentThread().getName());
                        try {
                            class1.notify();
                            class1.wait();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
     }


     public void test5() throws InterruptedException {
         CountDownLatch countDownLatch = new CountDownLatch(2);
         Object lock = new Object();
         new Thread(()->{
            synchronized (lock){
                try {
                    System.out.println("线程1开始进行等待");
                    lock.wait();
                    System.out.println("线程1  开始被唤醒继续执行");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程1 开始运行");
             }
             countDownLatch.countDown();
        }).start();
        Thread.sleep(1000);
         new Thread(()->{
             synchronized (lock){

                 System.out.println("我是                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         线程222");
                 lock.notify();
                 try {
                     Thread.sleep(3000);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
                 System.out.println("等待时间完毕");
                 countDownLatch.countDown();
             }
         }).start();
         countDownLatch.await();


         int [] a = new int[10];

         AtomicReference<Integer> atomicReference = new AtomicReference<>();
//         atomicReference.accumulateAndGet()
         Pair<Object, Object> objectObjectPair = Pair.of(1,1);

     }

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.getAndAdd(3);
        System.out.println(atomicInteger.get());
        Integer a = new Integer(1000);
        AtomicStampedReference<Integer> stampR = new AtomicStampedReference<>(a, 0);
        System.out.println(stampR.compareAndSet(a, 101, stampR.getStamp(), stampR.getStamp() + 1));
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
//
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(()-> {

            try {
                System.out.println("线程1 抢夺");
                reentrantLock.lock();
                Thread.sleep(1000);
                System.out.println("线程1 抢到了");
                reentrantLock.unlock();
            } catch (Exception e) {
                System.out.println("线程1 报错");
            }
            System.out.println("线程1 执行完毕");

        }).start();
        Thread.sleep(100);
        Thread thread = new Thread(() -> {
            try {
                System.out.println("线程2开始抢夺");
                reentrantLock.lockInterruptibly();
                System.out.println("线程2 抢夺完成");
            } catch (InterruptedException e) {
                System.out.println("报错");
//                throw new RuntimeException(e);
            }
        });
        thread.start();

        new Thread(()->{
            thread.interrupt();
            System.out.println("中断完毕");
        }).start();

        Thread.sleep(30000);
        CountDownLatch countDownLatch = new CountDownLatch(2);
        countDownLatch.countDown();
        countDownLatch.await();
    }

}
