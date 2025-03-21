package org.example.springbootdemo5.demos.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectTest {


//    @Around("execution(* org.example.springbootdemo5.demos.web.BasicController.hello(..))")
    @Around("execution(* org.example.springbootdemo5.demos.service.aspect.AspectTest.test1(..))")
    public Object excute(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("增强hello方法");
        String a = "11";
             return joinPoint.proceed();
    }


    @Test
    public void test1() {
        System.out.println("我是test1");
    }


    public void test2(){
        System.out.println("test2");
    }
}
