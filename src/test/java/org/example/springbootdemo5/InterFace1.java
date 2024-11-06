package org.example.springbootdemo5;

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

    void method2();

     void methodInter1();
}
