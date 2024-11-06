package org.example.springbootdemo5.Strings;

import org.junit.jupiter.api.Test;

public class StringBuildTest {

    @Test
    public void test1(){
        StringBuilder a1 = new StringBuilder("a");
        String a =null;
        a1.append(a);
        System.out.println(a1);
        int[] arr = new int[]{1,3,4};
    }
}
