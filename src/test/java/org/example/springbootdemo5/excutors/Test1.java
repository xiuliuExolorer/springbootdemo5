package org.example.springbootdemo5.excutors;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {


    @Test
    void test1() throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(atomicInteger::incrementAndGet);
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(10000,TimeUnit.SECONDS);

        System.out.println("结束"+atomicInteger);

    }
}
