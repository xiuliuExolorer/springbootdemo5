package org.example.springbootdemo5;

import io.lettuce.core.cluster.api.sync.Executions;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3<T extends Comparable & Serializable> {


//    private AtomicInteger i =new AtomicInteger();
    private String key = "test";
    HashMap<String, Integer> map = new HashMap<>(){{put(key,0);}};

    @Test
    public void test1(){

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 100, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));

        for (int i1 = 0; i1 < 1000; i1++) {
            threadPoolExecutor.execute(()->add());
        }
        threadPoolExecutor.shutdown();
        try {
            if(!threadPoolExecutor.awaitTermination(1,TimeUnit.HOURS)){
                threadPoolExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            threadPoolExecutor.shutdownNow(); // 强制关闭
            Thread.currentThread().interrupt(); // 恢复中断状态
        }
        System.out.println("最终i的值为："+map.get(key));
    }

    void add() {
        synchronized (key) {
            Integer value = map.get(key);
            map.put(key, ++value);
        }
    }

    //            threadPoolExecutor.execute(()->{
//                if(map.containsKey(key)){
//                    synchronized (key){
//                        Integer value = map.get(key);
//                        map.put(key,++value);
//                    }
//                }
//            });

    @Test
    void test6(){
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(() -> System.out.println("1"));
            thread1.start();
            new Thread(() -> {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    System.out.println("报错了啊");
                }
                System.out.println("2");}).start();

        }
    }
    @Test
    void test7(){
        TransferEnum[] values = TransferEnum.values();
        Map<String, TransferEnum> map = Arrays.stream(TransferEnum.values())
                .collect(Collectors.toMap(TransferEnum::getFromAddress, Function.identity()));
        String s = Optional.ofNullable(map.get("12")).map(TransferEnum::getToAddress).orElse(null);
        System.out.println(s);
    }
    @Test
    void test8(){
//        Cat cat = new Cat();
//        cat.dog = new Dog();
//        Dog dog2 = new Dog();
//        dog2.cat = cat;
//        cat.method2();
//        cat.dog.method1();
        String s = null;
        System.out.println(s);
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o);

        List<Integer> collect = Stream.of(1, 3, 6).map((x) -> x + 1).filter(x -> x > 2).collect(Collectors.toList());

    }

    @Test
    public void test9(){
        Integer a = 10000;
        long b = 10000;
        System.out.println(a==b);

    }



}
