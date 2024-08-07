package org.example.springbootdemo5;

import org.junit.jupiter.api.Test;

public interface InterFace1 {

    String a = "";
     static void main(String[] args) {

    }
    static int getInt(){
         return 1;
    }

    default void method1(){
        System.out.println("我是接口的默认方法");
    }

     abstract void method2();
}
