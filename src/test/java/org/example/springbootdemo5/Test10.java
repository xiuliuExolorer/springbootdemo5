package org.example.springbootdemo5;


import org.junit.jupiter.api.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class Test10 {


    private static ThreadLocal<Integer> local = new ThreadLocal();

    public static void main(String[] args, Supplier<CountDownLatch> supplier) throws InterruptedException {

        CountDownLatch countDownLatch = supplier.get();

        new Thread(() -> {
            System.out.println("2线程名字：" + Thread.currentThread().getName() + " threadLocalValue：" + local.get());
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();

        extra4cted();
//        threadPoolExecutor.shutdown();

    }

    private static void extra4cted() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new SynchronousQueue<>(true));
        threadPoolExecutor.execute(()->{
            for (int i = 0; i < 10; i++) {
                ThreadLocal.withInitial(() -> 1);
                ThreadLocal<Integer> local = new ThreadLocal();
                local.set(i);
            }
        });
    }

    private static void extracted(CountDownLatch countDownLatch) {
        new Thread(() -> {
            local.set(10);
            System.out.println("1线程名字："+Thread.currentThread().getName() +" threadLocalValue："+local.get());
            countDownLatch.countDown();
        }).start();
    }

    @Test
    void sortTest(){
        int[] arrs = {2,3,1,7,9,8};
        quickSort(arrs,0,arrs.length-1);
        for (int ar : arrs) {
            System.out.println(ar);
        }
    }

    void swap(int[] arrs , int a , int b){
        if(a==b){
            return;
        }
        arrs[a] = arrs[a]^arrs[b];
        arrs[b]= arrs[a]^arrs[b];
        arrs[a]= arrs[a]^arrs[b];
    }

    void quickSort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }
        int originalLow = low;
        int originalHigh = high;
        int piot = low;
        while (low<high){
            while (low<high&&arr[high]>=arr[piot]){
                high--;
            }
            while (low<high&&arr[low]<=arr[piot]){
                low++;
            }
            if(low<high){
                swap(arr,high,low);
            }
        }
        swap(arr,piot,high);
        quickSort(arr,originalLow,high-1);
        quickSort(arr,high+1,originalHigh);
    }

    private static ThreadLocal<String> threadLocal = new ThreadLocal();
    public static void main(String[] args) {
//        Student student = new Student("ming");
//        System.out.println(student.hashCode());
//        Integer a = 1000;
//        int b = 1000;
//        System.out.println(a.equals(b));
//        Thread thread = Thread.currentThread();
//
//        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
//        objectThreadLocal.get();
        //虚引用
//        Object object = new Object();
//        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
//        PhantomReference<Object> phantomReference = new PhantomReference<>(object,referenceQueue);
//        phantomReference.get();
//        System.gc();
        //弱引用
        WeakReference weakReference = new WeakReference<>(new Object());
        System.out.println("weakReference "+weakReference.get());




        System.out.println(threadLocal.get());
        System.out.println("weakReference2 "+weakReference.get());
        System.out.println(threadLocal.get());
        HashMap<String, Object> map = new HashMap<>();
        map.put("a",1);
        map.get("a");
//        System.out.println(weakReference.get());
//        WeakHashMap<String, String> map = new WeakHashMap<>();

    }

    static private ThreadLocal threadLocal2 = new ThreadLocal();


    class A extends ThreadPoolExecutor{
        public A(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            threadLocal2.remove();
            super.afterExecute(r, t);
        }
    }

}
