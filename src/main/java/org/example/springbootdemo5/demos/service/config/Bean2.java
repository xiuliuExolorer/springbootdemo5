package org.example.springbootdemo5.demos.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Primary
public class Bean2 {
//    @Autowired
//    @Lazy
    private Bean2 bean2;
    @Autowired
    private Bean1 bean1;

    public Bean1 getBean1() {
        return bean1;
    }

    private String a = "a";

    public String method2(){
        System.out.println("我是method2");
        return "method2";
    }

    private void setA(String a){
        this.a = a;
    }

    public String getA(){
        return this.a;
    }


    public void method1(){
//        bean2.method3();
        System.out.println("我是bean2的method1");
    }

    public void method3(){
        System.out.println("我是bean的method3");
    }

    public static void main(String[] args) {

    }
//
//    @Test
//    public void test1(){
//        new Bean4();
//    }
}
