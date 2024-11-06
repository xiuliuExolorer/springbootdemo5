package org.example.springbootdemo5.demos.web;

import org.example.springbootdemo5.demos.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/batchAddStudent")
    public void batchAddStudent(){
        studentService.batchInsert();
    }

    @RequestMapping("/select")
    public void select(){
        studentService.selectById();
    }

    @RequestMapping("/insertA")
    public void insert(){
        studentService.insetA();
//        studentService.selectById();
    }

}
