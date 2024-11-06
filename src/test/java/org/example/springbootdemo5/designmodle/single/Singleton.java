package org.example.springbootdemo5.designmodle.single;

public class Singleton {
    private static class SingletonHolder {  
    private static final Singleton INSTANCE = new Singleton();  
    }  
    private Singleton (){
        System.out.println("初始化开始");
    }
    public static final Singleton getInstance() {
        System.out.println("调用getInstance");
        return SingletonHolder.INSTANCE;  
    }  
}
