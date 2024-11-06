package org.example.springbootdemo5.demos.service.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

@Component
public class Bean4 extends Bean5{

    {
        System.out.println("bean4的代码快");
    }
    static {
        System.out.println("bean4的静态代码块");
    }


//    @Autowired

    private Bean4 bean4;
//    @Autowired

    public void setBean4(Bean4 bean4) {
        this.bean4 = bean4;
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
        new Bean4();
    }
}
