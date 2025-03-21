package org.example.springbootdemo5.springTest;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.springbootdemo5.demos.service.StudentService;
import org.example.springbootdemo5.demos.service.config.Bean2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@Slf4j
@SpringBootTest()
@RunWith(SpringRunner.class)
public class SpringTest1 {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Bean2 bean2;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void test1(){
//        studentService.batchInsert();
//        studentService.selectById();
////        studentService.insetA();
//        Bean1 bean1 = bean2.getBean1();

//        log.info("bean1:{},bean11:{}",bean1,bean1.getBean2().getBean1());

//        Student student1;
//        Student student2;
//        // 第一次查询（开启并关闭会话）
//        try (SqlSession session1 = sqlSessionFactory.openSession()) {
//            student1 = session1.getMapper(StudentMapper.class).selectById(15l);
//
//        } // 关闭session1，数据存入二级缓存
//
//        // 第二次查询（新会话）
//        try (SqlSession session1 = sqlSessionFactory.openSession()) {
//            student2 = session1.getMapper(StudentMapper.class).selectById(15l);
//        } // 命中二级缓存
//        Assert.assertEquals(student2,student1);
//        A a1 = new A();
//        A a2 = new A();
//        Assert.assertEquals(a2,a1);

        CompletableFuture.runAsync(() -> System.out.println(111));

        String p = System.getProperty("java.util.concurrent.ForkJoinPool.common.maximumSpares");

        System.out.println(p);

    }

    public static void main(String[] args) {
        String p = System.getProperty("java.util.concurrent.ForkJoinPool.common.maximumSpares");
        System.out.println(p);
    }
    
    
}
