package org.example.springbootdemo5.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
@Slf4j
public class SynTest {
    public SynTest() {
        System.out.println("synTest 执行了构造方法");
    }

    SynTest2 map = new SynTest2();

    public void method1() {
        synchronized (map) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("睡眠完成");
        }
    }

    public void method2() {
        map.method2();
        log.info("lalala");
    }

    @Test
    public void test1() throws InterruptedException {
//        SynTest synTest = new SynTest();
//        CountDownLatch countDownLatch = new CountDownLatch(2);
//        new Thread(() -> {
//            synTest.method1();
//            countDownLatch.countDown();
//        }).start();
//        new Thread(() -> {
//            synTest.method2();
//            countDownLatch.countDown();
//        }).start();
//        countDownLatch.await();


    }

    public static void main(String[] args) {

    }
}
