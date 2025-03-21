package org.example.springbootdemo5.demos.service.forkjoin;

import org.junit.Test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AqsTest extends AbstractQueuedSynchronizer {

    volatile  int  a = 1;
    @Test
    public void test1(){
        compareAndSetState(0,2);
        System.out.println(getState());
    }
}
