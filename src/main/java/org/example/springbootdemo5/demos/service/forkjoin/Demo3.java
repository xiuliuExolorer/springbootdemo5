package org.example.springbootdemo5.demos.service.forkjoin;

import org.junit.Test;

public class Demo3 extends Demo{

    public static void main(String[] args) {
        new Demo().test10();
    }

    {
        System.out.println("demo3 {}");
    }

    @Test
    public void test1(){
        try {
            new Thread(()->{
                int i1 = 1/0;
            }).start();
        } catch (Exception e) {
            System.out.println("报错了");
        }
    }
}
