package org.example.springbootdemo5.demos.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBean {

    @Bean
    public Bean1 get1(){
        return new Bean1();
    }

    @Bean
    public Bean2 get2(){
        return new Bean2();
    }


}
