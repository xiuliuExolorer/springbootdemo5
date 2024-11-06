package org.example.springbootdemo5.demos.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

import java.util.Random;
import java.util.concurrent.*;

@Configuration
public class ThreadPoolConfig extends AsyncConfigurerSupport {


    @Override
    public Executor getAsyncExecutor() {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
                200, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), (r) -> {
            Thread thread = new Thread(r);
            thread.setName("名为" + new Random().nextInt(10));
            return thread;
        });
        return threadPoolExecutor;
    }
}
