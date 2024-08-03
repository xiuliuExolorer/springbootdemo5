package org.example.springbootdemo5;

import java.util.HashMap;
import java.util.Objects;

public class Student {
    public String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public static void main(String[] args) {
        HashMap<Student, Student> studentHashMap = new HashMap<>();
        studentHashMap.put(new Student("zhen"),new Student("zhen"));
        studentHashMap.put(new Student("zhen"),new Student("zhen"));

        System.out.println(studentHashMap.size());
    }
}
