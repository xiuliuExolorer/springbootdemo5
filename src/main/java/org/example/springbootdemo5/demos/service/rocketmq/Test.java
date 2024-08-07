package org.example.springbootdemo5.demos.service.rocketmq;

import org.springframework.beans.factory.DisposableBean;

public class Test implements DisposableBean {
    @Override
    public void destroy() throws Exception {

    }

    public static void main(String[] args) {
        System.out.println("增加一个1+1");
        System.out.println("测试回滚git");
        System.out.println("再次测试回滚");
    }
}
