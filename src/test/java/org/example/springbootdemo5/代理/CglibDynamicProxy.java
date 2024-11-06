package org.example.springbootdemo5.代理;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("method")) System.out.println("我在方法 method 之前增强");
        Object result = methodProxy.invokeSuper(o, objects);
        if(method.getName().equals("method")) System.out.println("我在方法 method 后面增强");
        return result;
    }
}
