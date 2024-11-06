package org.example.springbootdemo5;

import com.hou.demostarter2.EnAbleA;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication()
@MapperScan("org.example.springbootdemo5.demos.mapper")
@EnableAsync
@EnAbleA(enabled = true)
public class SpringbootDemo5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo5Application.class, args);
//        Bean1 bean11 = new Bean1(null);
    }

}
