package org.example.springbootdemo5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootDemo5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo5Application.class, args);
    }

}
