package org.example.springbootdemo5.springTest;

import lombok.extern.slf4j.Slf4j;
import org.example.springbootdemo5.demos.service.StudentService;
import org.example.springbootdemo5.demos.service.config.Bean1;
import org.example.springbootdemo5.demos.service.config.Bean2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@SpringBootTest()
@RunWith(SpringRunner.class)
public class SpringTest1 {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Bean2 bean2;
    @Test
    public void test1(){
//        studentService.batchInsert();
//        studentService.selectById();
//        studentService.insetA();
        Bean1 bean1 = bean2.getBean1();

        log.info("bean1:{},bean11:{}",bean1,bean1.getBean2().getBean1());
    }

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.countDown();
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

    }
    
    
}
