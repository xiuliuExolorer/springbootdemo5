package org.example.springbootdemo5.demos.service.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TestPhantomReference {

    public static void main(String[] args) {
        ReferenceQueue phantomRQ = new ReferenceQueue();//虚引用队列
//        ReferenceQueue weakRQ = new ReferenceQueue();//弱引用队列
        TestClass testClass = new TestClass();//被回收对象
        PhantomReference pr = new PhantomReference(testClass, phantomRQ);//虚引用
//        WeakReference wr = new WeakReference(testClass, weakRQ);//弱引用
        System.out.println("pr: before gc: " + pr.get() + ", " + phantomRQ.poll());
//        System.out.println("wr: before gc: " + wr.get() + ", " + weakRQ.poll());
        testClass = null;//去掉强引用
        System.gc();//执行第一次gc
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pr: after first gc: " + pr.get() + "," + phantomRQ.poll());
//        System.out.println("wr: after first gc: " + wr.get() + "," + weakRQ.poll());
        System.gc();//执行第二次gc
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//    new BlockingQueue<>()
        System.out.println("pr: after second gc: " + pr.get() + "," + phantomRQ.poll());
//        System.out.println("wr: after second gc: " + wr.get() + "," + weakRQ.poll());
    }
}

class TestClass {//被回收对象的类覆写了finalize方法
//    @Override
//    protected void finalize() throws Throwable{
//        super.finalize();
//        System.out.println("finalize method executed");
//    }
}