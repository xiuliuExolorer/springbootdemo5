package org.example.springbootdemo5.demos.service.reference;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Test1 {


    public static void main(String[] args) {
        Collection<Object> objects = Collections.synchronizedCollection(new ArrayList<>());
//        objects.add();
    }

    @Test
    public void test1(){
        int k = 0;
        k = k++;
        System.out.println(k);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put()
    }

    @Test
    public void test2(){
        int k = 0;
        k = ++k;
        System.out.println(k);
    }
}
