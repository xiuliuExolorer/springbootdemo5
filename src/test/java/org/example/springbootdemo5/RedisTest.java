package org.example.springbootdemo5;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RedisTest {

    RedisTemplate redisTemplate;
    public void test1(){
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
//        RedisConnection connection = connectionFactory.getConnection();

        try(RedisConnection connection = connectionFactory.getConnection()){
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
