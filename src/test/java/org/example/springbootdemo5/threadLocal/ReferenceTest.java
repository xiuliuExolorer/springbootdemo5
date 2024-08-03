package org.example.springbootdemo5.threadLocal;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.WeakHashMap;

public class ReferenceTest<T> extends WeakReference<T> {

    public int value;

    public ReferenceTest(T referent) {
        super(referent);
    }

    static String key = "abc";

    public static void main(String[] args) {
        java.lang.ThreadLocal<Object> objectThreadLocal = null;
        objectThreadLocal.set("1");
        int x,y, z= 0;
        x=y=z;

        WeakReference<String> stringWeakReference = new WeakReference<>(new String("abcc"));
        stringWeakReference.clear();
//        System.gc();
//        System.out.println(stringWeakReference.get());
//
//
//        ReferenceTest referenceTest = new ReferenceTest(key);
//        key = null;
//        System.gc();
//        System.out.println(referenceTest.get());

        Integer a = 10000;

        Integer b = 10000;
        Integer f = 10000;
        System.out.println(f==b);

        String c = new String("c") ;
        String d = "c";
        String e = "c";
        System.out.println(e==d);

//        List<Integer> list = Arrays.asList(1, 2, 4, 3);
//        list.sort(Comparator.comparingInt(Integer::intValue).reversed());

        WeakHashMap<Object, Object> objectObjectWeakHashMap = new WeakHashMap<>();



    }

}
