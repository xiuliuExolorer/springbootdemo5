package org.example.springbootdemo5.lamda;

public class Class3 {

    synchronized void method1() throws InterruptedException {
        System.out.println("method1开始");
        Thread.sleep(10000);
        System.out.println("method1结束");
    }

    synchronized void method2() throws InterruptedException {
        System.out.println("method2开始");
        Thread.sleep(10000);
        System.out.println("method2结束");
    }
}
