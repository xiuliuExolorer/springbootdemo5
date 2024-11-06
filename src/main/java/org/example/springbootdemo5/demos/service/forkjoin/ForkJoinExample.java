package org.example.springbootdemo5.demos.service.forkjoin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000; // 阈值
    private final long[] array;
    private final int start;
    private final int end;

    public SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        // 如果任务足够小，直接计算
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // 否则，分解任务
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);
            leftTask.fork(); // 异步执行左侧任务
            long rightResult = rightTask.compute(); // 同步执行右侧任务
            long leftResult = leftTask.join(); // 等待左侧任务完成并获取结果
            return leftResult + rightResult; // 合并结果
        }
    }
}

public class ForkJoinExample {
    public static void main(String[] args) throws InterruptedException {
        long[] array = new long[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1; // 初始化数组
        }

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        long result = pool.invoke(task); // 执行任务
        System.out.println("Total sum: " + result);
        Thread.currentThread().join();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(()-> System.out.println(1));
        int a   =10& ~1;

//        new PriorityQueue<>()
    }
}