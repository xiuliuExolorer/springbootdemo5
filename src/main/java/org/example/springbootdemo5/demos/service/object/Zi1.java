package org.example.springbootdemo5.demos.service.object;

import lombok.Data;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

@Data
public class Zi1 extends Fu1{

    private String name;

    private Fu1 fu1;

//    @Scheduled(fixedDelay = 10,fixedRate = )
    void method2(){
        System.out.println("我是method2");

        ArrayList<Object> objects = new ArrayList<>();
//        objects.add()
//        EnumMap enumMap = new EnumMap<>();

    }

    public static void main(String[] args) throws InterruptedException {
//        Integer age = Optional.ofNullable(new Zi1()).map(Zi1::getFu1).map(Fu1::getAge).orElse(10);
//        System.out.println(age);
//
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
////        objectObjectHashMap.put()
//        Semaphore semaphore = new Semaphore(10);
        CountDownLatch countDownLatch = new CountDownLatch(1);
//        countDownLatch.countDown();
        countDownLatch.await();
//        semaphore.acquire();

//        SharedLock sharedLock = new SharedLock();



    }

    @Override
    void method1() {
        System.out.println( "我是1 的method");
    }
}
