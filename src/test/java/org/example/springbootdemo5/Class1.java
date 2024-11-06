package org.example.springbootdemo5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 */
public class Class1 {

    static final List list = new ArrayList();
    private void method1(){

    }
    protected void method2(){
        System.out.println();
    }

    void method3(){
        new Thread(() -> System.out.println()).start();
    }

    public static void main(String[] args) {

//        String s = new String("hello");
//        String s ="a";
//        String a = "hello";
////        String b = "world";
////        String c = a+b;
////        String e = new String("helloworld");
////        String f = "helloworld";
////        String d = "helloworld";
//        System.out.println(a==s);
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();

        map1.put("a","a");
        map2.put("a","a");

        System.out.println(map1.get("a") == map2.get("a"));
    }
}
