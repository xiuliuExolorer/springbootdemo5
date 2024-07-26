package org.example.springbootdemo5;

import io.netty.util.concurrent.DefaultThreadFactory;
import org.assertj.core.api.Object2DArrayAssert;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Test {


    @org.junit.jupiter.api.Test
    public void test1(){
        Student ming = new Student("小明");
        Student hong = ming;

        Developer developer = new Developer(ming);

        Student student = developer.student;
        method1(developer.student);
        developer.student = null;

        Executors.newFixedThreadPool(1);

        new ThreadPoolExecutor(5, 10, 100l,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),Executors.defaultThreadFactory());
    }

    void method1(Student student){
        student = null;
    }
//        student.name = "校长";
    /**
     * Adds support for the Scala language. The following features are available for free with IntelliJ IDEA Community Edition:
     * Coding assistance (highlighting, completion, formatting, refactorings, etc.)
     * Navigation, search, information about types and implicits
     * Integration with sbt and other build tools
     * Testing frameworks support (ScalaTest, Specs2, uTest)
     * Scala debugger, worksheets and Ammonite scripts
     *  Support for Play Framework, Akka and Scala.js is enabled in IntelliJ IDEA Ultimate.
     */
    @org.junit.jupiter.api.Test
    public void test2(){
//        new Dog();
//        The 'peek()' call does not change the final count and might be optimized out
//        Arrays.stream(new int[]{1,2}).peek(System.out::println).count();
//        Stream.of(1);
        // lettuce
        PriorityQueue priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.offer(6);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        priorityQueue.offer(5);
        priorityQueue.offer(4);
        Iterator iterator = priorityQueue.iterator();
        Object[] array = priorityQueue.toArray();
        Arrays.sort(array);
        System.out.print("有序遍历");
        for (Object o : array) {
            System.out.print(o);
        }
        System.out.println("");
        priorityQueue.forEach(System.out::print);
        System.out.println("");
        System.out.println("poo最小值"+priorityQueue.poll());
//        priorityQueue.add()


//        int[][] ints = new int[][]{{1},{2}};
    }
    @org.junit.jupiter.api.Test
    void tes3(){
//        int[] arrs = {1, 3, 4, 5};;
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        list.sort((Comparator.comparingInt(o -> (int) o)).reversed());
        for (Integer i : list) {
            System.out.println(i);
        }
//        Comparator<String> caseInsensitiveOrder = String.CASE_INSENSITIVE_ORDER;

        HashMap<Object, Object> map = new HashMap<>();
//        map.clone()

    }
//        student = null;

//        System.out.println(student.name);
}
