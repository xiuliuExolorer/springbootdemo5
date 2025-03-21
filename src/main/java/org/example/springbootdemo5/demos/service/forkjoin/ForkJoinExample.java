package org.example.springbootdemo5.demos.service.forkjoin;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.*;

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
        long[] array = new long[3];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1; // 初始化数组
        }
//        new ThreadPoolExecutor()
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        long result = pool.invoke(task); // 执行任务
        System.out.println("Total sum: " + result);
        while (pool.isTerminated()){
            System.out.println("执行完了");
            return;
        }
        System.out.println("first commit");
        System.out.println("second commit");
        System.out.println("three commit");
        System.out.println("four");
        System.out.println("five");
        System.out.println("six");
        System.out.println("seven");
        System.out.println("eight");


//        new BigDecimal()

        Executors.newWorkStealingPool();
//        new ThreadPoolExecutor()

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        executorService.submit(()-> System.out.println(1));
//        int a   =10& ~1;
//
////        new PriorityQueue<>()

    }

    @Test
    public void test1() throws InterruptedException {
//        Semaphore semaphore = new Semaphore(10);
//
//        semaphore.release();
//        semaphore.acquire();
//
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
////        reentrantLock.unlock();
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put(null,null);

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Lock readLock = readWriteLock.readLock();
//        Lock writeLock = readWriteLock.writeLock();

        Thread thread = new Thread(() -> {
            readLock.lock();
            System.out.println("thread lock");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("error");
                throw new RuntimeException(e);
            }
            readLock.unlock();
            System.out.println("thread unlock");
        });

        Thread thread2 = new Thread(() -> {
            readLock.lock();
            System.out.println("thread2 lock");
            readLock.unlock();
            System.out.println("thread2 unlock");
        });
        thread.start();
        thread2.start();

        thread.join();
        thread2.join();
    }
    @Test
    public void test2(){
//        int[] numbersArr = {1, 2, 3};
//        Arrays.stream(numbersArr).parallel().sum();
//        System.out.println(Arrays.stream(numbersArr).parallel().reduce(1, (a, b) -> a + b));
//        System.out.println(Arrays.stream(numbersArr).reduce(1, (a, b) -> a + b));

        System.out.println();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Lock readLock = readWriteLock.readLock();
        readLock.unlock();
        Lock writeLock = readWriteLock.writeLock();
        readLock.lock();
        writeLock.lock();
    }

    @Test
    public void test3() throws InterruptedException {
//        int[] numbersArr = {1, 2, 3};
//        Arrays.stream(numbersArr).parallel().sum();
//        System.out.println(Arrays.stream(numbersArr).parallel().reduce(1, (a, b) -> a + b));
//        System.out.println(Arrays.stream(numbersArr).reduce(1, (a, b) -> a + b));
        int a = 10;
//        System.out.println(a);
//        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//        Lock writeLock = readWriteLock.writeLock();
//        Lock readLock = readWriteLock.readLock();
//        readLock.lock();
//        writeLock.lockInterruptibly();
//        writeLock.unlock();
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

        Thread thread = new Thread(() -> {
            reentrantLock.lock();
            reentrantLock.unlock();
        },"hou");

        Condition condition = reentrantLock.newCondition();
        condition.await();
        condition.signal();
        thread.start();
        thread.join();
        reentrantLock.unlock();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));
        threadPoolExecutor.execute(null);
        threadPoolExecutor.shutdown();

        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        objects.add(null);
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.add(null);


    }

    @Test
    public void test4() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        Condition condition = reentrantLock.newCondition();
        Thread thread1 = new Thread(() -> {
            System.out.println("线程1 开始抢锁");
            reentrantLock.lock();
            System.out.println("线程1 获取到锁了");
            try {
                condition.await();
                System.out.println("线程1 等待完毕");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.unlock();
        }, "hou1");

        thread1.start();
        Thread.sleep(100);
        Thread thread = new Thread(() -> {
            System.out.println("线程2 开始抢锁");
            reentrantLock.lock();
            System.out.println("线程2 获取到锁了");

            try {
                System.out.println("线程2 开始睡觉");
                Thread.sleep(5000);
                condition.signal();
                System.out.println("condition获取完毕");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            reentrantLock.unlock();
        }, "hou2");
        thread.start();

        //3
        Thread.sleep(100);
        Thread thread3 = new Thread(() -> {
            System.out.println("线程3 正在获取锁");
            reentrantLock.lock();
            System.out.println("线程3 获取到锁了");
            reentrantLock.unlock();
        }, "hou3");


        thread3.start();
        thread.join();
        thread1.join();

    }


    @Test
    public void test6() throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong();
        System.out.println(atomicLong.addAndGet(10));


//        LongAdder adder = new LongAdder();
//        for (int i = 0; i < 102; i++) {
//             new Thread(() -> {
//                 adder.add(1);
//            }).start();
//        }
//        System.out.println(adder.sum());
        Thread.sleep(1000000);
//        System.out.println(adder.intValue());
//        adder.sum()
//        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
//        objectObjectLinkedHashMap.put(1,1);
//        objectObjectLinkedHashMap.put(3,3);
//        objectObjectLinkedHashMap.put(2,2);
//        objectObjectLinkedHashMap.forEach((key,value)-> System.out.println(key));


    }


}