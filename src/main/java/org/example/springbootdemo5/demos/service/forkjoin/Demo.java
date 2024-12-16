package org.example.springbootdemo5.demos.service.forkjoin;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Demo {
    private static final Logger log = LoggerFactory.getLogger(Demo.class);
    public int publicVar = 1;
    protected int protectedVar = 2;
    private int privateVar = 3;
    public int[] arrayData = new int[]{1, 2, 3};
    @Override
    public String toString() {
        return "Demo{" +
                "publicVar=" + publicVar +
                ", protectedVar=" + protectedVar +
                ", privateVar=" + privateVar +
                ", arrayData=" + Arrays.toString(arrayData) +
                '}';
    }

    @Test
    public   void privateDemo() throws NoSuchFieldException, IllegalAccessException {
//        Demo instance = new Demo();
//        VarHandle varHandle = MethodHandles.privateLookupIn(Demo.class, MethodHandles.lookup())
//                .findVarHandle(Demo.class, "privateVar", int.class);
//        varHandle.set(instance, 33);
//        System.out.println(instance);

        AtomicInteger atomicInteger = new AtomicInteger(1);
        int i = atomicInteger.getAndAdd(1);
        AtomicReference<Integer> objectAtomicReference = new AtomicReference<>();
        objectAtomicReference.compareAndExchange(0,1);
        log.info("old:{},new:{}",i,atomicInteger.get());
        System.out.println("old:");

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.isShutdown();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory());

        threadPoolExecutor.execute(()-> System.out.println());
    }

    @Test
   public void test2(){
        System.out.println(1^0);
    }

}
