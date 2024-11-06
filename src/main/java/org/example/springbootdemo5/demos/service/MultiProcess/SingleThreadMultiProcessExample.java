package org.example.springbootdemo5.demos.service.MultiProcess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleThreadMultiProcessExample {
    public static void main(String[] args) {
        // 创建一个子进程来执行耗时的任务
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", ".", "ChildProcess");
        
        try {
            // 启动子进程
            Process process = processBuilder.start();

            // 主进程继续执行其他操作
            System.out.println("主进程正在执行其他操作...");

            // 读取子进程的输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("子进程输出: " + line);
            }

            // 等待子进程完成
            int exitCode = process.waitFor();
            System.out.println("子进程完成，退出代码: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 子进程类
