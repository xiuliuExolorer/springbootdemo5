package org.example.springbootdemo5.designmodle.single;

public class Person {
    public static void main(String[] args) {
        Singleton.getInstance();
        Singleton.getInstance();
    }
}
