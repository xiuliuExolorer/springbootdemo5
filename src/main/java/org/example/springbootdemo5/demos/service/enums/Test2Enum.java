package org.example.springbootdemo5.demos.service.enums;

public enum Test2Enum {

    HOU("a",18),MING("b",20);
    private String a;
    private Integer age;

    Test2Enum(String a,Integer age){
        this.a =a ;
        this.age = age;
    }

    public static void main(String[] args) {
        Test2Enum hou = Test2Enum.valueOf("HOU");
        System.out.println(hou.age);
    }
}
