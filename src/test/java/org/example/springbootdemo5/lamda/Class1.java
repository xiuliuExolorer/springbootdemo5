package org.example.springbootdemo5.lamda;

import lombok.extern.slf4j.Slf4j;
import org.example.springbootdemo5.代理.Class2;
import org.junit.jupiter.api.Test;

@Slf4j
public class Class1 {

    // 关键字在静态方法上，锁为当前Class对象
    public static synchronized void staticLock() throws InterruptedException {
        log.info("进入classLock 开始"+Thread.currentThread().getName());
        Thread.sleep(10000);
        log.info("进入classLock 结束"+Thread.currentThread().getName());
        // code
    }

    public static synchronized void staticLock2() throws InterruptedException {
        log.info("进入classLock 开始"+Thread.currentThread().getName());
        Thread.sleep(10000);
        log.info("进入classLock 开始"+Thread.currentThread().getName());
        // code
    }

    // 关键字在代码块上，锁为括号里面的对象
    public void blockLock() throws InterruptedException {
        synchronized (this.getClass()) {
            Thread.sleep(10000);
            // code
        }
    }

    public synchronized void lockTest1() throws InterruptedException {
        log.info("进入lockTest1 ");
        Thread.sleep(10000);
        log.info("lockTest1结束");
    }

    public synchronized void lockTest2() throws InterruptedException {
        log.info("进入lockTest2 ");
        Thread.sleep(10000);
        log.info("lockTest2结束");
    }

    synchronized static void method2() throws InterruptedException {
        log.info("method2 开始");
        Thread.sleep(10000);
        log.info("method2 结束");
    }

    synchronized static void method3() throws InterruptedException {
        log.info("method3 开始");
        Thread.sleep(10000);
        log.info("method3 结束");
    }

    void synTest3() throws InterruptedException {
        synchronized (this){
            log.info("synTest3 开始");
            Thread.sleep(10000);
            log.info("synTest3 结束");
        }
    }

    void synTest4() throws InterruptedException {
        synchronized (Class1.class){
            log.info("synTest3 开始");
            Thread.sleep(10000);
            log.info("synTest3 结束");
        }
    }
    @Test
    void test1() throws InterruptedException {
//        Class1.method2();
//        Class1.method3();
//        Class1 class1 = new Class1();
//        Class1 class2 = new Class1();
//        class1.method2();
//        class2.method2();
        Class3 class2 = new Class3();
        Class2 class3 = new Class2();
    }
    public static void main(String[] args) {
        Class1 class1 = new Class1();
        new Thread(()-> {
            try {
//                System.out.println("进入方法1开始");
                class1.lockTest2();
//                System.out.println("方法1结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Class1 class2 = new Class1();
        new Thread(()-> {
            try {
//                System.out.println("进入方法2开始");
                class2.lockTest2();
//                System.out.println("进入方法2结束");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

//    new Thread(()->{})
    void method1(){
        Thread thread = new Thread(() -> {
            System.out.println("线程1");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("线程2");
        });
//        thread.join();
    }


}
