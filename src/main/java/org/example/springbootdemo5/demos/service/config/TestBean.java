package org.example.springbootdemo5.demos.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBean {

    public TestBean(){
        System.out.println();
    }


    @Bean
    public Bean2 get2(){
        return new Bean2();
    }

    @Bean
    public Bean2 get22(){
        return new Bean2();
    }


//    @Bean(name = "bean22")
//    public Bean2 get22(){
//        return new Bean2("aa");
//    }

//    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
////        double a = 0.1;
////        double b = 0.2;
////        System.out.println(a+b);
////        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
////        objectObjectHashMap.get("");
////        objectObjectHashMap.put("","");
////        ArrayList<Integer> integers = new ArrayList<>();
////        integers.add(1);
////        integers.add(2);
////        Iterator<Integer> iterator = integers.iterator();
////        while (iterator.hasNext()){
////            Integer next = iterator.next();
////            System.out.println(next);
////            if(next.equals(1)) iterator.remove();
////        }
////        System.out.println(integers);
//
////        Class<?> aClass = Class.forName("org.example.springbootdemo5.demos.service.config.Bean2");
////        Object object = aClass.getDeclaredConstructor().newInstance();
////        Method method2 = aClass.getMethod("method2");
////        method2.setAccessible(true);
////        String invoke = (String) method2.invoke(object);
////        System.out.println("invoke 返回结果："+invoke);
//
//        try {
//            // 创建 Bean2 的实例
//            Bean2 bean2 = new Bean2();
//
//            // 获取 Bean2 的 Class 对象
//            Class<?> clazz = bean2.getClass();
//
//            // 获取私有方法 method2
//            Method method = clazz.getDeclaredMethod("setA", String.class);
//
//            // 设置方法可访问
//            method.setAccessible(true);
//
//            // 调用私有方法
//            String result = (String) method.invoke(bean2,"b");
//
//            // 输出结果
//            System.out.println("调用结果: " + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

//    @Test
//    public void test1(){
//        try {
//            Class<?> aClass = Class.forName("org.example.springbootdemo5.demos.service.config.Bean2");
//            Object object = aClass.getDeclaredConstructor().newInstance();
////            Field field = aClass.getDeclaredField("a");
//
//            //设置 值
//            Method setA = aClass.getDeclaredMethod("setA", String.class);
//            setA.setAccessible(true);
//            setA.invoke(object,"hello");
//            //获取值
//            Method getA = aClass.getDeclaredMethod("getA");
//            getA.setAccessible(true);
//            String a = (String) getA.invoke(object);
//
//            System.out.println("A的值是 ："+a);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}
