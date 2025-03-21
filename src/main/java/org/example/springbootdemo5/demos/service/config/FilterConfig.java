package org.example.springbootdemo5.demos.service.config;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class FilterConfig
 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  {

    }




    static HashMap<String, Integer> hashMap = new HashMap<>();


    public static void main(String[] args) throws InterruptedException {

        HashMap<Object, Object> hashMap1 = new HashMap<>();
        hashMap1.put(null,null);
        String mvpStr = new String("mvp");
        hashMap.put(mvpStr,0);

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                add(mvpStr);
            });
            thread.start();
            thread.join();
        }
        System.out.println(hashMap.get(mvpStr));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(null);

        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
//        queue.add();
    }


     static void add(String key){
        synchronized (key){
            Integer value = hashMap.get(key);
            if(value!=null){
                hashMap.put(key,hashMap.get(key)+1);
//                hashMap.putIfAbsent();
//                hashMap.computeIfAbsent()
            }
        }
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
