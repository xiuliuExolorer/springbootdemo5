package org.example.springbootdemo5.designmodle.single;

public class SafeSingle {


    static volatile private  Person person;

    public static Person getSinglePerson(){
        if(person==null){
            synchronized (SafeSingle.class){
                if(person==null){
                    person = new Person();
                }
            }
        }
        return person;
    }

    public static void main(String[] args) {
//        Integer.valueOf()
    }
}
