package org.example.springbootdemo5.demos.service.forkjoin;

import lombok.Data;
import org.example.springbootdemo5.demos.service.dto.Person1;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {
    private static final Logger log = LoggerFactory.getLogger(Demo.class);
    public int publicVar = 1;
    protected int protectedVar = 2;
    private int privateVar = 3;
    public int[] arrayData = new int[]{1, 2, 3};

    {
        System.out.println("demo {}");
    }
    static {
        System.out.println("demo static {}");
    }

    @Override
    public String toString() {
        return "Demo{" +
                "publicVar=" + publicVar +
                ", protectedVar=" + protectedVar +
                ", privateVar=" + privateVar +
                ", arrayData=" + Arrays.toString(arrayData) +
                '}';
    }

    @Test
    public void privateDemo() throws NoSuchFieldException, IllegalAccessException {
//        Demo instance = new Demo();
//        VarHandle varHandle = MethodHandles.privateLookupIn(Demo.class, MethodHandles.lookup())
//                .findVarHandle(Demo.class, "privateVar", int.class);
//        varHandle.set(instance, 33);
//        System.out.println(instance);

        AtomicInteger atomicInteger = new AtomicInteger(1);
        int i = atomicInteger.getAndAdd(1);
        AtomicReference<Integer> objectAtomicReference = new AtomicReference<>();
        objectAtomicReference.compareAndExchange(0, 1);
        log.info("old:{},new:{}", i, atomicInteger.get());
        System.out.println("old:");

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.isShutdown();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory());

        threadPoolExecutor.execute(() -> System.out.println());
    }

    @Test
    public void test2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            System.out.println("线程名字：" + Thread.currentThread().getName());
            countDownLatch.countDown();
        });
        executorService.execute(() -> {
            System.out.println("线程名字：" + Thread.currentThread().getName());
            countDownLatch.countDown();
        });


        countDownLatch.await();

        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        objectObjectLinkedHashMap.put(1, 1);

        ArrayList<Integer> integers = new ArrayList<>();
        LinkedList<Object> objects = new LinkedList<>();
        objects.remove();
        integers.remove(null);

    }

    @Test
    public void test4() throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(2);
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 10,
                100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory());
////        ExecutorService executorService = Executors.newFixedThreadPool(0);
////        new Thread(()-> System.out.println("名字"+Thread.currentThread().getName())).start();
//        executorService.execute(()-> {System.out.println("线程名字："+Thread.currentThread().getName());countDownLatch.countDown();});
//        Thread.sleep(20000);
//        executorService.execute(()-> {System.out.println("线程名字："+Thread.currentThread().getName());countDownLatch.countDown();});
//        Thread.currentThread().isInterrupted();
//        countDownLatch.await();
        executorService.shutdown();
//        executorService.shutdownNow();
//        executorService.isTerminated();
//
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.tryLock(1000,TimeUnit.SECONDS);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println(1), 10, 10, TimeUnit.SECONDS);

//        executorService.execute();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        Condition condition = reentrantLock.newCondition();
        condition.await();
        condition.signal();
        reentrantLock.lockInterruptibly();


    }


    protected void test10() {

    }


    void test11() {

    }

    public static void main(String[] args) throws InterruptedException {


        CountDownLatch countDownLatch = new CountDownLatch(2);
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(() -> {
            countDownLatch.countDown();
            try {
                reentrantLock.lock();
                System.out.println("线程1 开始抢锁");
                Thread.sleep(10000);
                reentrantLock.unlock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Thread thread = new Thread(() -> {
            countDownLatch.countDown();
            try {
                Thread.sleep(1000);
                System.out.println("线程2 开始抢夺锁");
                reentrantLock.lockInterruptibly();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("报异常了");
//                throw new RuntimeException(e);
            }
        });
        thread.start();
        Thread.sleep(2000);
        System.out.println("开始 干预");
        thread.interrupt();
        countDownLatch.await();
    }


    @Test
    public void test13() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread = new Thread(() -> {
            LockSupport.park(this);
            System.out.println("xiao");
            countDownLatch.countDown();
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("开始干扰");
        thread.interrupt();
        countDownLatch.await();
        System.out.println("主线程结束");
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        condition.await();
        condition.signal();


        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put(null, null);

    }

    @Test
    public void test14() {
//        int k = 0;
//        k =k++;
//        System.out.println(k);
//
//        TreeMap<Object, Object> map = new TreeMap<>();
//        map.put(0,0);
//        map.put(1,0);

        Integer a = null;
        int b = 0;
//        System.out.println(b>a);
        int list[] = {1, 3, 4};
        List<int[]> list1 = Arrays.asList(list);
        System.out.println(list1.size());

        HashSet<Object> objects = new HashSet<>();

        objects.add(1);
        HashMap<Object, Object> hashMap = new HashMap<>();
//        objects.remove()
//        ArrayList arrayList = new ArrayList(Arrays.asList(list));
    }
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private Redisson redisson;
    @Test
    public void test15(){

        HashMap<Object, Object> hashMap = new HashMap<>();
        for (int i = 0; i < 11; i++) {
            hashMap.put(new Person1(),10);
        }
        System.out.println(hashMap.size());

        hashMap.remove(hashMap.keySet().stream().toArray()[8]);
        System.out.println(hashMap.size());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS
                , new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());
//        threadPoolExecutor.execute();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//        scheduledExecutorService.scheduleAtFixedRate();
        RLock lock = redisson.getLock("a");
        lock.tryLock();
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
//        concurrentSkipListMap.
        RLock lock1 = redisson.getFairLock("a");
        lock1.tryLock();
        lock1.lock();
    }

    @Test
    public void test16(){
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        System.out.println(objectObjectHashMap.putIfAbsent(1, 1));
//        System.out.println(objectObjectHashMap.putIfAbsent(1, 1));

        int a = 20;
        switch (a){
            case 1:
                System.out.println(1);
                break;
            case 10:
            case 20:
                System.out.println("11 or 20");
                break;
            default:
                System.out.println("默认");
        }
    }


    @Test
    public void test18() throws InterruptedException {
        // 配置Redisson，使用单机模式（请根据实际环境调整地址和端口）
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);
        CountDownLatch countDownLatch = new CountDownLatch(2);

        RLock lock = redisson.getLock("lock1");
        lock.lock(50000,TimeUnit.SECONDS);
        countDownLatch.countDown();
        System.out.println("主线程 正在强锁");


        new Thread(()->{
            System.out.println("子线程来了");
            lock.lock();
            countDownLatch.countDown();
            System.out.println("子线程来强锁了");
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
        }).start();
        System.out.println("开始睡眠");
        Thread.sleep(50000);
        lock.unlock();
        System.out.println("主线程正在释放锁");
        countDownLatch.await();
        System.out.println("结束");
    }

    @Test
    public void test19(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("hou");
        lock.lock();
        lock.unlock();
    }


    @Test
    public void quickSort(){
        int arr[] = {3,2,1};
        sort(0,arr.length-1,arr);
        for (int i : arr) {
            System.out.println(i);
        }
        ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> 1);
        integerThreadLocal.set(1);
        integerThreadLocal.get();
        InheritableThreadLocal<Object> local = new InheritableThreadLocal<>();
        local.set(1);
        local.get();
        new Thread(()-> System.out.println()).start();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();


    }


    void sort(int low,int high,int [] arr){
        int origLow = low, origHigh = high;
        if(low>=high){
            return ;
        }
        int pivot = arr[high];
        while (low<high){
            while (pivot>=arr[low]&&low<high) low++;
            while (pivot<=arr[high]&&low<high) high--;

            if(low<high){
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            }
        }
        int temp = arr[origHigh];
        arr[origHigh] = arr[low];
        arr[low] = temp;

        sort(origLow,low-1,arr);
        sort(low+1,origHigh,arr);
    }

    @Data
    class C{
        String str = "111";
    }
    @Data
    class B{
        C c= new C();
    }
    @Test
    public void test20(){
        B b = new B();
        String s = Optional.ofNullable(b).map(B::getC).map(C::getStr).orElse("null");
        System.out.println(s);
        HashMap<Object, Object> map = new HashMap<>();
        Object object = map.putIfAbsent(1, 2);
        Object object3 = map.putIfAbsent(1, 2);
        Object object2 = map.computeIfAbsent(2, (a)->3);
        System.out.println(object);
        System.out.println(object2);
        System.out.println(object3);
        AtomicInteger atomicInteger  = new AtomicInteger(10);
        atomicInteger.incrementAndGet();
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        Semaphore semaphore = new Semaphore(2);
//        semaphore.acquire();
//        semaphore.acquire();

    }

    @Test
    public void test21() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        Thread thread1 = new Thread(() -> {
            reentrantLock.lock();
            System.out.println("子线程抢夺成功");
            reentrantLock.unlock();
        });
        thread1.start();
        Thread.sleep(10000);
        thread1.interrupt();
        Thread.sleep(1000);
        System.out.println("start ");
        Thread.sleep(100000);
        reentrantLock.unlock();

//        Thread thread = new Thread();
//        thread.join();
    }

    @Test
    public void test22() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("线程1 开始睡眠");
                Thread.sleep(200000);
                System.out.println("线程1 睡眠结束");
                reentrantLock.unlock();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();

        Thread.sleep(1000);
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 start lock");
            try {
                reentrantLock.lockInterruptibly();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println("thread1------ get lock");
                reentrantLock.unlock();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        thread2.start();

        System.out.println("main thread start sleep");
        Thread.sleep(10000);
        thread2.interrupt();
        System.out.println("interrupt end");
        Thread.sleep(100000);
        System.out.println("main thread end sleep");

//        new CyclicBarrier()
    }

    int i = 1;
    @Test
    public void test23() throws InterruptedException {


        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("执行最后任务");
        });

        for (int i1 = 0; i1 < 2; i1++) {
            new Thread(()->{
                try {
                    System.out.println("do "+(++i));
                    cyclicBarrier.await();
                    System.out.println("lalala");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        Thread.sleep(5000);

        new Thread();


        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        forkJoinPool.execute();

    }







}