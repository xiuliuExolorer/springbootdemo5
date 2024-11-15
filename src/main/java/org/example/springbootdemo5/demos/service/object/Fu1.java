package org.example.springbootdemo5.demos.service.object;

import lombok.Data;

@Data
public class Fu1 {

    private int age;
    void method1(){
        System.out.println("父类--我是method1");
    }
}
