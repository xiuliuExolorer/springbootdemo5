package org.example.springbootdemo5.threadLocal;

public class GarbageCollectionExample {

    static class MyClass {
        private String name;

        public MyClass(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("begin Object finalized: " + this);
        }

        @Override
        public String toString() {
            return "MyClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass("Example Object");

        System.out.println("Object created: " + obj);

        // 将 obj 设为 null，断开强引用
        obj = null;

        // 手动调用垃圾回收
        System.gc();

        System.out.println("After garbage collection");
    }
}