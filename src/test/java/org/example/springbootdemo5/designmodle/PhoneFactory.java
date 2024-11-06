package org.example.springbootdemo5.designmodle;

public class PhoneFactory {


    DoPhone getDoPhone(Integer type){
        if(type==1){
            return  new MiPhone();
        }
        return null;
    }
}
