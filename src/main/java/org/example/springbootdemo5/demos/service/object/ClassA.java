package org.example.springbootdemo5.demos.service.object;

import org.example.springbootdemo5.demos.service.enum2.Enum1;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ClassA <T>{

    T a ;

    T getA(){
        return a;
    }

    T setA(T a){
        this.a = a;
        return a;
    }

    public static void main(String[] args) throws InterruptedException {
//   |     new EnumMap<>()
        Map<Enum1, Object> enum1ObjectMap = Collections.synchronizedMap(new EnumMap<>(Enum1.class));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();


    }
}
