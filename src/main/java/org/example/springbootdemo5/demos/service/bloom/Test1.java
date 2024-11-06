package org.example.springbootdemo5.demos.service.bloom;

import org.junit.Test;

import java.util.BitSet;
import java.util.Optional;
import java.util.concurrent.*;

public class Test1 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("睡眠完成");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1 + 1;});
        Integer i = future.get();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println("主线程结束"+i);
        BitSet bitSet = new BitSet();

    }
    @Test
    public void test2() {
//        System.out.println(Optional.ofNullable(null).map()orElseGet()
        Object a = new Object();
        Object b = new Object();

        new Thread(() -> {
            synchronized (a) {
                System.out.println("a-我获取到了a的锁");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b) {
                    System.out.println("a-我获取到了b");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println("b-我获取到了b的锁");
                synchronized (a) {
                    System.out.println("b-我获取到了a的锁");
                }
            }
        }).start();

    }

    @Test
    public void test3(){
        Integer a = 10;
        Optional.ofNullable(a).map(x->x+1);
    }




}
