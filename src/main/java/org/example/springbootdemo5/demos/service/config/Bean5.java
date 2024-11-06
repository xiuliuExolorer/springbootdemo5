package org.example.springbootdemo5.demos.service.config;

public class Bean5 {

    {
        System.out.println("Bean5的代码块");
    }
    static {
        System.out.println("bean5的静态代码块");
    }
    public void method1(){
        System.out.println("我是method5");
    }
}
