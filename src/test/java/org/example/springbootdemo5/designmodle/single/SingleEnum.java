package org.example.springbootdemo5.designmodle.single;

public enum SingleEnum {

    INSTANCE;

    public void method1(){
        System.out.println("method1");
    }

    private String a;
}
