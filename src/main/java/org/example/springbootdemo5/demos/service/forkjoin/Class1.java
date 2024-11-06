package org.example.springbootdemo5.demos.service.forkjoin;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Class1 {

    public void test1(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Object> objectCompletableFuture = new CompletableFuture<>();
        CompletableFuture<?> submit = (CompletableFuture<?>) executorService.submit(() -> System.out.println(1));
        Thread thread = new Thread(System.out::println);
        Future<?> submit1 = executorService.submit(() -> System.out.println());
        Future<Integer> submit2 = executorService.submit(() -> 1);
        submit1.isDone();

    }
}
