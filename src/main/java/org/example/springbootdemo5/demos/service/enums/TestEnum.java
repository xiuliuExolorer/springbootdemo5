package org.example.springbootdemo5.demos.service.enums;

public enum TestEnum {


    TEST2("a");
    TestEnum(String a){
        this.a = a;
    }
    private String a;

    TestEnum getBya(String a){
        for (TestEnum value : TestEnum.values()) {
            if(value.a.equals(a) ){
                return value;
            }
        }
        //默认
        return TEST2;
    }

}
