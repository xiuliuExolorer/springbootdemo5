package org.example.springbootdemo5.demos.service.object;

public class ClassB extends ClassA<ClassB>{
    public static void main(String[] args) {
        new ClassB().setA(new ClassB()).getA();
    }
}
