package org.example.springbootdemo5.demos.service.threadLocal;

public class LocalTest
{

    public static void main(String[] args) throws InterruptedException {



        // 1 父子线程传递值

        InheritableThreadLocal<Long> longInheritableThreadLocal = new InheritableThreadLocal<>();
        longInheritableThreadLocal.set(10l);

        Thread thread = new Thread(() -> {
            System.out.println(longInheritableThreadLocal.get());
            longInheritableThreadLocal.set(20l);
            System.out.println(longInheritableThreadLocal.get());
        });
        thread.start();
        thread.join();
        System.out.println(longInheritableThreadLocal.get());


        // 2  使用同一个方法初始化local

        ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> 23);


        Thread thread1 = new Thread(() -> {
            System.out.println(integerThreadLocal.get());
        });
        thread1.start();
        thread1.join();

    }
}
