package org.example.springbootdemo5.demos.service.forkjoin;

public class SingleTon {

    public static SingleTon singleTon= null;

    public synchronized static SingleTon getInstance(){
        if(singleTon==null){
            synchronized (singleTon){
                if(singleTon==null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
