package org.example.springbootdemo5;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test9 {
    public static void main(String[] args) {
//        System.out.println("我在add分支上增加了一行内容");
//        System.out.println("我在add分支上增加了一行内容2");
//        System.out.println("测试merge 我在add分支上增加了一行内容3");
//
//        System.out.println("测试merge 我在add分支上增加了一行内容4");
//        System.out.println("测试merge 我在add分支上增加了一行内容5");
//
//        System.out.println("ad分支 测试1");
//        System.out.println("ad分支 测试2");

//        Executors.newScheduledThreadPool()
        System.out.println("1");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(()-> System.out.println("1"),0,1000, TimeUnit.MILLISECONDS);

    }
}
