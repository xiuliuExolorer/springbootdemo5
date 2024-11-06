package org.example.springbootdemo5.demos.service.MultiProcess;

class ChildProcess {
    public static void main(String[] args) {
        try {
            // 模拟耗时操作
            System.out.println("子进程开始执行耗时任务...");
            Thread.sleep(5000); // 模拟5秒的耗时操作
            System.out.println("子进程任务完成!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}