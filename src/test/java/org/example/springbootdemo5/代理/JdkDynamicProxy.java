package org.example.springbootdemo5.代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkDynamicProxy implements InvocationHandler {

    private Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("method")) System.out.println("我是jdk动态代理 method 之前增强");
        Object invoke = method.invoke(target, args);
        if(method.getName().equals("method")) System.out.println("我是jdk动态代理 method 之后增强");
        return invoke;
    }

    public JdkDynamicProxy(Object target){
        this.target = target;
    }
}
