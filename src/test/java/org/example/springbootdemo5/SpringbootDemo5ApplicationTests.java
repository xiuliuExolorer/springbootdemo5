package org.example.springbootdemo5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class SpringbootDemo5ApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("Hello World");
        System.out.println();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.shutdown();
    }

}
