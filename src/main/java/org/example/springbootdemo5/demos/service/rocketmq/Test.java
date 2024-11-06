package org.example.springbootdemo5.demos.service.rocketmq;

import org.springframework.beans.factory.DisposableBean;

import java.util.Arrays;
import java.util.HashMap;

public class Test implements DisposableBean {
    @Override
    public void destroy() throws Exception {

    }

    public static void main(String[] args) {
//        System.out.println("增加一个1+1");
//        System.out.println("测试回滚git");
//        System.out.println("再次测试回滚");
//        System.out.println(Math.pow(2, 3));
//        System.out.println(Math.log(1));
        char [] aChar = "cba".toCharArray();
        char [] bChar = "abc".toCharArray();
        Arrays.sort(aChar);
        Arrays.sort(bChar);
        System.out.println(aChar);
        System.out.println(bChar);
        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(Arrays.equals(aChar, bChar));


    }
}
