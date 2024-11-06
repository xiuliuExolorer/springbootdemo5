package org.example.springbootdemo5.lock.内部;

import org.example.springbootdemo5.lock.SharedResource;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest2 extends SharedResource{



    void method1(){
        SharedResource sharedResource = new SharedResource();
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
    }



}
