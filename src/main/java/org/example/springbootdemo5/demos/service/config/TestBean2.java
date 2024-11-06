package org.example.springbootdemo5.demos.service.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBean2 {

    public TestBean2(){
        System.out.println(1);
    }
}
