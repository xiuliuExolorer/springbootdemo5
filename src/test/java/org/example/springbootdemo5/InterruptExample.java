package org.example.springbootdemo5;

public class InterruptExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Running: " + i);
                    Thread.sleep(1000); // 模拟长时间运行的任务
                }
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep."+Thread.currentThread().getName());
                // 恢复中断状态
                Thread.currentThread().interrupt();
            }

            // 检查中断状态
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread was interrupted.");
            }
        });

        thread.start();

        try {
            Thread.sleep(3000); // 主线程等待3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); // 中断子线程
        if(thread.isInterrupted()){
            System.out.println("子线程中断了name="+thread.getName());
        }else {
            System.out.println("子线程没有中断"+thread.getName());
        }
    }
}