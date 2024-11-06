package org.example.springbootdemo5.代理;

import org.springframework.cglib.proxy.Enhancer;




public class CglibTest {

    void method1(){
        System.out.println("我是method1 等待被增强");
    }

    public static void main1(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new CglibDynamicProxy());
        CglibTest cglibTest = (CglibTest) enhancer.create();
        cglibTest.method1();
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new CglibDynamicProxy());
        CglibTest cglibTest = (CglibTest)enhancer.create();
        cglibTest.method1();
    }

}
