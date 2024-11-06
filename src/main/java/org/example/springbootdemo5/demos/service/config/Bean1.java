package org.example.springbootdemo5.demos.service.config;

import org.example.springbootdemo5.demos.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Bean1 {


    private  Bean2 bean2;

    private final StudentService studentService;

    private static final Logger log = LoggerFactory.getLogger(Bean1.class);

    //构造函数注入
    Bean1(StudentService studentService) {
        this.studentService = studentService;
        log.info("studnent:{}",studentService);
    }
    // setter注入


    @Autowired
    public void setBean1(Bean1 bean1) {
        log.info("调用setter注入了");
        this.bean1 = bean1;
    }

    public Bean2 getBean2() {
        return bean2;
    }

    private  Bean1 bean1;

//    @Autowired
//    public void setBean1(Bean1 bean1) {
//        this.bean1 = bean1;
//    }

    void metho1() {
        System.out.println("2 的 方法");
    }

    void mehod2() {
        System.out.println("2 的方法");
    }

    private volatile int anInt = 10;

    public static void main(String[] args) {

        String a = "10000000";
        String b = "2000000";
//        log.info("a:{},b:{}",a.hashCode(),b.hashCode());
        log.info("{}", 5 % 15);
    }


}
