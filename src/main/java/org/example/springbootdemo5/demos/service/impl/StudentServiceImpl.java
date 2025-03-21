package org.example.springbootdemo5.demos.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.springbootdemo5.demos.domain.Student;
import org.example.springbootdemo5.demos.mapper.StudentMapper;
import org.example.springbootdemo5.demos.service.StudentService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
* @author 11290
* @description 针对表【student】的数据库操作Service实现
* @createDate 2024-08-23 20:38:55
*/
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    @Qualifier
    private StudentMapper studentMapper;



    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void testTransactionTest(){
        transactionTemplate.execute((status)->{
            return null;
        });
    }

    public void batchInsert(){
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 10; i < 200000; i++) {
            int i1 = new Random().nextInt(100);
            students.add(Student.builder()
                    .name(i1 +"明")
                    .height(i1)
                    .phone("1")
                    .color(1)
                    .age(1)
                    .build());
        }

        studentMapper.insertBatch(students);
    }


//    @Resource
//    private TransactionTemplate transactionTemplate;


    @Resource
    private SqlSessionFactory sqlSessionFactory;

//    @Async
    public void selectById(){
        log.info("当前线程：{}", Thread.currentThread().getName());
        Student students = studentMapper.selectById(15l);
        Student students2 = studentMapper.selectById(15l);
        Assert.assertEquals(students, students2);
        System.out.println("result-->"+students);

//        System.out.println(studentMapper.selectById(1));
    }

//    @Test
    public void test1(){
        Student student1;
        Student student2;
        // 第一次查询（开启并关闭会话）
        try (SqlSession session1 = sqlSessionFactory.openSession()) {
            student1 = session1.getMapper(StudentMapper.class).selectById(15l);

        } // 关闭session1，数据存入二级缓存

        // 第二次查询（新会话）
        try (SqlSession session1 = sqlSessionFactory.openSession()) {
            student2 = session1.getMapper(StudentMapper.class).selectById(15l);
        } // 命中二级缓存
        Assert.assertEquals(student2,student1);
//        A a1 = new A();
//        A a2 = new A();
//        Assert.assertEquals(a2,a1);
    }


    class A{
    }

    @Transactional(rollbackFor = Exception.class)
    public void insetA(){
        studentMapper.insertBatch(List.of(Student.builder().name("A").height(1).phone("1")
                .color(1)
                .age(1)
                .build()));
        // 使用 ApplicationContext 获取代理实例
        StudentService proxy = applicationContext.getBean(StudentService.class);
        proxy.insetB(); // 通过代理调用 insetB
//        insetB();
        int i = 1/0;
    }

    @Transactional(propagation = Propagation.NESTED)
    public void insetB(){
        studentMapper.insertBatch(List.of(Student.builder().name("B").height(1).phone("1")
                .color(1)
                .age(1)
                .build()));

    }

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(100));
    }

    public void test2(){
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {

                return null;
            }
        });
    }


}




